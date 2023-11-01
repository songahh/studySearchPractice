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

    @Column(name = "study_board_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private StudyBoard studyBoard;

    @Column(name = "tag_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Tag tag;
}
