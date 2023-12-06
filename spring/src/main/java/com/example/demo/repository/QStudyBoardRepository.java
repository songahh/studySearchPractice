package com.example.demo.repository;

import com.example.demo.domain.QStudyBoard;
import com.example.demo.domain.QUser;
import com.example.demo.domain.StudyBoard;
import com.example.demo.domain.dto.StudyBoardDto;
import com.example.demo.domain.dto.StudyBoardSearchDto;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.core.types.dsl.PathBuilderFactory;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class QStudyBoardRepository {
    private final JPAQueryFactory queryFactory;

    public Page<StudyBoardDto> findAllStudyBoardsByCategory(Pageable pageable, StudyBoardSearchDto searchDto){

        QStudyBoard studyBoard = QStudyBoard.studyBoard;
        QUser user = QUser.user;

        JPAQuery<StudyBoardDto> query = queryFactory.select(Projections.constructor(StudyBoardDto.class,
                studyBoard.id.as("id"), user.id.as("writerId"), user.nickName.as("writerNickName"),
                studyBoard.subject.as("subject"), studyBoard.content.as("content")
                        , studyBoard.likeCnt.as("likeCnt"), studyBoard.viewCnt.as("viewCnt"), studyBoard.open.as("open")
                ))
                .from(studyBoard)
                .join(studyBoard.user, user)
                .where(
                        cotainQueryInSubject(searchDto.getQuery())
                                .or(cotainQueryInContent(searchDto.getQuery()))
                );

        if(!searchDto.getOrderByColumn().isEmpty())
            query.orderBy(getPath(searchDto.getOrderByColumn()));

        List<StudyBoardDto> responseDto = query.orderBy(studyBoard.createdDate.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
        return new PageImpl<>(responseDto, pageable, responseDto.size());
    }

    private OrderSpecifier getPath(String column){
        PathBuilder pathBuilder = new PathBuilderFactory().create(StudyBoard.class);
        return pathBuilder.getString(column).desc();
    }

    private BooleanExpression cotainQueryInSubject(String query){
        return QStudyBoard.studyBoard.subject.contains(query);
    }

    private BooleanExpression cotainQueryInContent(String query){
        return QStudyBoard.studyBoard.content.contains(query);
    }

}
