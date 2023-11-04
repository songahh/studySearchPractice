package com.example.demo.domain;

import com.example.demo.config.BaseTimeEntity;
import java.util.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Table(name = "study_board")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudyBoard extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

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

    @OneToMany(mappedBy = "tagId", cascade = CascadeType.PERSIST, fetch=FetchType.LAZY)
    private List<Tag> hashTagList;

}
