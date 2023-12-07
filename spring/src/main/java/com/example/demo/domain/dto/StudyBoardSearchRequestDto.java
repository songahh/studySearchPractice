package com.example.demo.domain.dto;


import lombok.*;
import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class StudyBoardSearchRequestDto {
    private String word;
    private String nickname;
    private String orderby;
    private Boolean open;
    private List<String> tags = new ArrayList<>();
}
