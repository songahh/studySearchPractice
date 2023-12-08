package com.example.demo.domain.repository.querydsl;

import com.example.demo.domain.*;
import com.example.demo.domain.dto.StudyBoardSearchRequestDto;
import com.example.demo.domain.dto.StudyBoardSearchResponseDto;
import com.example.demo.domain.entity.StudyBoard;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.*;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import java.util.List;
import java.util.Set;

@Repository
@RequiredArgsConstructor
@Slf4j
public class QStudyBoardRepository {
    private final JPAQueryFactory queryFactory;

    private Long countAll(Pageable pageable, StudyBoardSearchRequestDto searchDto, Set<String> tagList){
        QStudyBoard studyBoard = QStudyBoard.studyBoard;
        QStudyBoardHasTag studyBoardHasTag = QStudyBoardHasTag.studyBoardHasTag;
        QUser user = QUser.user;
        QTag tag = QTag.tag;

        Long totalPage = queryFactory.selectFrom(studyBoard)
                .join(user).on(studyBoard.user.id.eq(user.id))
                .join(studyBoardHasTag).on(studyBoard.id.eq(studyBoardHasTag.studyBoard.id))
                .join(tag).on(tag.tagId.eq(studyBoardHasTag.tag.tagId))
                .where(
                        isOpen(searchDto.getOpen()),
                        containsTagInTagList(tagList),
                        containsQuery(searchDto.getWord())
                )
                .groupBy(studyBoard.id)
                .having(checkTagSize(tagList))
                .fetchCount();

        return totalPage;
    }

    public Page<StudyBoardSearchResponseDto> findAll(Pageable pageable, StudyBoardSearchRequestDto searchDto){

        QStudyBoard studyBoard = QStudyBoard.studyBoard;
        QStudyBoardHasTag studyBoardHasTag = QStudyBoardHasTag.studyBoardHasTag;
        QUser user = QUser.user;
        QTag tag = QTag.tag;

        Set<String> tagList = searchDto.getTagList();

        JPAQuery<StudyBoardSearchResponseDto> query = queryFactory.select(Projections.constructor(StudyBoardSearchResponseDto.class,
                studyBoard.id.as("id"), user.id.as("userId"), user.nickName.as("nickName"), studyBoard.createdDate.as("createdTime")
                        , studyBoard.open.as("open"), studyBoard.subject.as("subject"), studyBoard.content.as("content"),
                        Expressions.stringTemplate("group_concat({0})", tag.tagName).as("tag")
                , user.img.as("userImg"), studyBoard.likeCnt.as("likes"), studyBoard.viewCnt.as("eyes")
                ))
                .from(studyBoard)
                .join(user).on(studyBoard.user.id.eq(user.id))
                .join(studyBoardHasTag).on(studyBoard.id.eq(studyBoardHasTag.studyBoard.id))
                .join(tag).on(tag.tagId.eq(studyBoardHasTag.tag.tagId))
                .where(
                        isOpen(searchDto.getOpen()),
                        containsTagInTagList(tagList),
                        containsQuery(searchDto.getWord())
                )
                .groupBy(studyBoard.id)
                .having(checkTagSize(tagList))
                .orderBy(
                        getPath(searchDto.getOrderby())
                )
                .orderBy(studyBoard.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize());

        List<StudyBoardSearchResponseDto> responseDto = query.fetch();
        Long totalPage = countAll(pageable, searchDto, tagList);
        log.info("StudyBoard findAll 결과.............{},{}", responseDto,totalPage);
        return new PageImpl<>(responseDto, pageable, totalPage);
    }

    private BooleanExpression checkTagSize(Set<String> tagList){
        if (tagList==null || tagList.isEmpty()) {
            return null;
        }
        return Expressions.numberTemplate(Integer.class, "count(distinct {0})", QTag.tag.tagName).eq(tagList.size());
    }

    private OrderSpecifier getPath(String column){
        PathBuilder pathBuilder = new PathBuilderFactory().create(StudyBoard.class);
        return pathBuilder.getString(column).desc();
    }


    private BooleanExpression isOpen(boolean open){
        return QStudyBoard.studyBoard.open.eq(open);
    }

    private BooleanExpression containsTagInTagList(Set<String> taglist){
        if (taglist==null || taglist.isEmpty()) {
            return null;
        }
        return QTag.tag.tagName.in(taglist);
    }

    private BooleanExpression containsQuery(String query){
        if (StringUtils.isEmpty(query)) {
            return null;
        }
        return QStudyBoard.studyBoard.subject.contains(query)
                .or(QStudyBoard.studyBoard.content.contains(query))
                .or(QUser.user.nickName.contains(query));
    }


}
