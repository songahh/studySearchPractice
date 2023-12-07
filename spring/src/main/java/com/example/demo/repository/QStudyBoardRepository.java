package com.example.demo.repository;

import com.example.demo.domain.*;
import com.example.demo.domain.dto.StudyBoardSearchRequestDto;
import com.example.demo.domain.dto.StudyBoardSearchResponseDto;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.core.types.dsl.PathBuilderFactory;
import com.querydsl.core.types.dsl.StringPath;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class QStudyBoardRepository {
    private final JPAQueryFactory queryFactory;

    public Page<StudyBoardSearchResponseDto> findAll(Pageable pageable, StudyBoardSearchRequestDto searchDto){

        QStudyBoard studyBoard = QStudyBoard.studyBoard;
        QUser user = QUser.user;
        QTag tag = QTag.tag;

        JPAQuery<StudyBoardSearchResponseDto> query = queryFactory.select(Projections.constructor(StudyBoardSearchResponseDto.class,
                studyBoard.id.as("id"), user.id.as("userId"), user.nickName.as("nickName"), studyBoard.createdDate.as("createdTime")
                        , studyBoard.open.as("open"),
                studyBoard.subject.as("subject"), studyBoard.content.as("content")
                , user.img.as("userImg"), studyBoard.likeCnt.as("likes"), studyBoard.viewCnt.as("eyes")
                ))
                .from(studyBoard)
                .join(studyBoard.user, user)
                .join(studyBoard.hashTagList, tag)
                .where(
                        isOpen(searchDto.getOpen()).and(tag.tagName.in(searchDto.getTags()))
                                .and(
                                containsQueryInSubject(searchDto.getWord())
                                        .or(containsQueryInContent(searchDto.getWord()))
                                        .or(containsQueryInNickName(searchDto.getNickname()))
                        )
                ).orderBy(
                        getPath(searchDto.getOrderby())
                ).offset(pageable.getOffset())
                .limit(pageable.getPageSize());

        List<StudyBoardSearchResponseDto> responseDto = query.fetch();
        return new PageImpl<>(responseDto, pageable, responseDto.size());
    }


    private OrderSpecifier getPath(String column){
        PathBuilder pathBuilder = new PathBuilderFactory().create(StudyBoard.class);
        return pathBuilder.getString(column).desc();
    }

    private BooleanExpression isOpen(boolean open){
        return QStudyBoard.studyBoard.open.eq(open);
    }

    private BooleanExpression containsQueryInSubject(String query){
        return QStudyBoard.studyBoard.subject.contains(query);
    }

    private BooleanExpression containsQueryInContent(String query){
        return QStudyBoard.studyBoard.content.contains(query);
    }

    private BooleanExpression containsQueryInNickName(String query){
        return QUser.user.nickName.contains(query);
    }


}
