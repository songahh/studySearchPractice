package com.example.demo.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStudyBoardHasTag is a Querydsl query type for StudyBoardHasTag
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStudyBoardHasTag extends EntityPathBase<StudyBoardHasTag> {

    private static final long serialVersionUID = 1449983725L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStudyBoardHasTag studyBoardHasTag = new QStudyBoardHasTag("studyBoardHasTag");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QStudyBoard studyBoard;

    public final QTag tag;

    public QStudyBoardHasTag(String variable) {
        this(StudyBoardHasTag.class, forVariable(variable), INITS);
    }

    public QStudyBoardHasTag(Path<? extends StudyBoardHasTag> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QStudyBoardHasTag(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QStudyBoardHasTag(PathMetadata metadata, PathInits inits) {
        this(StudyBoardHasTag.class, metadata, inits);
    }

    public QStudyBoardHasTag(Class<? extends StudyBoardHasTag> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.studyBoard = inits.isInitialized("studyBoard") ? new QStudyBoard(forProperty("studyBoard"), inits.get("studyBoard")) : null;
        this.tag = inits.isInitialized("tag") ? new QTag(forProperty("tag")) : null;
    }

}

