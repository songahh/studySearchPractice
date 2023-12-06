package com.example.demo.domain.dto;

import com.example.demo.domain.User;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudyBoardDto {
    private Long id;
    private String writerId;
    private String writerNickName;
    private String subject;
    private String content;
    private Integer likeCnt;
    private Integer viewCnt;
    private Boolean open;
}
