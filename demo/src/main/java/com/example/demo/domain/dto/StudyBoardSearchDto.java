package com.example.demo.domain.dto;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class StudyBoardSearchDto {
    private String orderByColumn;
    private String query;
}
