package com.example.demo.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "study_board_has_tag")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudyBoardHasTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "study_board_id")
    private StudyBoard studyBoard;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id")
    private Tag tag;
}