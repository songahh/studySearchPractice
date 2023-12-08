package com.example.demo.domain.dto;


import lombok.*;
import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class StudyBoardSearchRequestDto {
    private String word;
    private String orderby;
    private Boolean open;
    private String tags;

    public Set<String> getTagList() {
        if(tags.length()==0) return null;
        Set<String> tagList = Arrays.stream(this.tags.substring(1).split("#")).collect(Collectors.toSet());
        return tagList;
    }
}
