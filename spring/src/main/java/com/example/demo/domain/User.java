package com.example.demo.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @Column(name = "user_id")
    private String id;

    @Column(name = "user_nickname", nullable = false)
    private String nickName;

    @Column(name = "user_img")
    private String img;
}
