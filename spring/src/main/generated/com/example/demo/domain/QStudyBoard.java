package com.example.demo.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStudyBoard is a Querydsl query type for StudyBoard
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStudyBoard extends EntityPathBase<StudyBoard> {

    private static final long serialVersionUID = -1757183507L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStudyBoard studyBoard = new QStudyBoard("studyBoard");

    public final com.example.demo.config.QBaseTimeEntity _super = new com.example.demo.config.QBaseTimeEntity(this);

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final ListPath<Tag, QTag> hashTagList = this.<Tag, QTag>createList("hashTagList", Tag.class, QTag.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> likeCnt = createNumber("likeCnt", Integer.class);

    public final BooleanPath open = createBoolean("open");

    public final StringPath subject = createString("subject");

    public final QUser user;

    public final NumberPath<Integer> viewCnt = createNumber("viewCnt", Integer.class);

    public QStudyBoard(String variable) {
        this(StudyBoard.class, forVariable(variable), INITS);
    }

    public QStudyBoard(Path<? extends StudyBoard> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QStudyBoard(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QStudyBoard(PathMetadata metadata, PathInits inits) {
        this(StudyBoard.class, metadata, inits);
    }

    public QStudyBoard(Class<? extends StudyBoard> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

