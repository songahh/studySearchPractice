package com.example.demo.domain.dto;

import lombok.Data;

import java.util.Arrays;

@Data
public class TestDto {
    private String keyword;
    private String[] tags = new String[10];

    @Override
    public String toString(){
        return keyword + " " + Arrays.toString(tags);
    }

}
