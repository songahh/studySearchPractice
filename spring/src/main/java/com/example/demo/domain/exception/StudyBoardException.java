package com.example.demo.domain.exception;


import lombok.Getter;
import org.springframework.http.HttpStatus;

public class StudyBoardException extends RuntimeException{
    @Getter
    HttpStatus status;
    public StudyBoardException(String msg, HttpStatus status){
        super(msg);
        this.status = status;
    }
}
