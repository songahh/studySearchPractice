package com.example.demo.controller;


import com.example.demo.domain.dto.StudyBoardSearchRequestDto;
import com.example.demo.domain.dto.StudyBoardSearchResponseDto;
import com.example.demo.service.StudyBoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/study")
@Slf4j
public class StudyBoardController {

    private final StudyBoardService boardService;

//    @ExceptionHandler
//    public ResponseEntity<?> handleException(){
//        return null;
//    }

    @PostMapping("/list")
    public ResponseEntity<?> findAll(@PageableDefault(size=7) Pageable pageable,
                                     @RequestBody StudyBoardSearchRequestDto params){
        log.info("params...........{}", params);
        Page<StudyBoardSearchResponseDto> responseDto = boardService.findAll(pageable, params);
        return ResponseEntity.ok(responseDto);
    }
}
