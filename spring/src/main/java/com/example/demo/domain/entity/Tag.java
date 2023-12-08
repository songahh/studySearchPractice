package com.example.demo.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tag")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="tag_id", nullable = false)
    private Long tagId;

    @Column(name="tag_name", unique = true, nullable = false)
    private String tagName;

    @OneToMany(mappedBy = "id", cascade = CascadeType.PERSIST, fetch=FetchType.LAZY)
    private List<StudyBoard> boardList = new ArrayList<>();
}
