package com.example.demo.domain;

import com.example.demo.config.BaseTimeEntity;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudyBoard extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private User writer;

    @Column(nullable = false)
    private String subject;

    @Column(nullable = false)
    private String content;

    @Column(name="like_cnt", nullable = false)
    @ColumnDefault("0")
    private Integer likeCnt;

    @Column(name="view_cnt", nullable = false)
    @ColumnDefault("0")
    private Integer viewCnt;

    @Column(nullable = false)
    @ColumnDefault("false")
    private Boolean open;


}
