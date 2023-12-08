package com.example.demo.domain.controller;


import com.example.demo.domain.dto.StudyBoardSearchRequestDto;
import com.example.demo.domain.dto.StudyBoardSearchResponseDto;
import com.example.demo.domain.exception.StudyBoardException;
import com.example.demo.domain.service.StudyBoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/study")
@CrossOrigin({"http://localhost:5173/"})
@Slf4j
public class StudyBoardController {

    private final StudyBoardService boardService;


    @ExceptionHandler({StudyBoardException.class})
    public ResponseEntity<String> handleException(StudyBoardException e){
        log.info("StudyBoard 에러 발생: {}", e.getMessage());
        return  new ResponseEntity<String>(e.getMessage(), e.getStatus());
    }

    @GetMapping("/list")
    public ResponseEntity<?> findAll(@PageableDefault(size=7) Pageable pageable,
                                     StudyBoardSearchRequestDto params){
        log.info("page, params...........{}, {}", pageable, params);
        Page<StudyBoardSearchResponseDto> responseDto = boardService.findAll(pageable, params);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        return new ResponseEntity<Page>(responseDto, headers, HttpStatus.OK);
    }
}
