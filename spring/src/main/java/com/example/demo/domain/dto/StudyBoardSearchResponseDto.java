package com.example.demo.domain.dto;

import com.example.demo.domain.Tag;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
@Setter
public class StudyBoardSearchResponseDto {
    Long id;
    String userId;
    String nickname;
    String createdTime;
    boolean open;
    String subject;
    String content;
    List<String> tag;
    String userImg;
    int likes;
    int eyes;

    public StudyBoardSearchResponseDto(Long id,
                                       String userId,
                                       String nickname,
                                       LocalDateTime createdTime,
                                       boolean open,
                                       String subject,
                                       String content,
//                                       List<Tag> tag,
                                       String userImg,
                                       int likes,
                                       int eyes
    ){
     this.id = id;
     this.userId = userId;
     this.nickname = nickname;
     this.createdTime = createdTime.toString();
     this.open = open;
     this.subject = subject;
     this.content = content;
//     this.tag = tag.stream().map(Tag::getTagName).collect(Collectors.toList());
     this.userImg = userImg;
     this.likes = likes;
     this.eyes = eyes;
    }
}
