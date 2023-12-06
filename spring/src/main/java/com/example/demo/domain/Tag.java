package com.example.demo.domain;

import lombok.*;

import javax.persistence.*;
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

    @Column(name="tag_nane", nullable = false)
    private Long tagName;

}
