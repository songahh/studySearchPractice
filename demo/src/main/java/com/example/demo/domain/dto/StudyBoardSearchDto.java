package com.example.demo.domain.dto;


import lombok.*;
import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class StudyBoardSearchDto {
    private String orderByColumn;
    private String query;
    private List<String> tag = new ArrayList<>();
}
