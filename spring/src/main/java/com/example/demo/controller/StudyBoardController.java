package com.example.demo.controller;


import com.example.demo.domain.dto.StudyBoardDto;
import com.example.demo.domain.dto.StudyBoardSearchDto;
import com.example.demo.domain.dto.TestDto;
import com.example.demo.service.StudyBoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/study")
@Slf4j
public class StudyBoardController {

    private final StudyBoardService boardService;

//    @GetMapping("/board")
//    public String findAllStudyBoardsByCategory(Model model,
//                                                                            @PageableDefault(size=10) Pageable pageable,
//                                                                            @RequestParam(value="col",required=false) String orderByCol,
//                                                                            @RequestParam(value="query", required=false) String query){
//        StudyBoardSearchDto searchDto = new StudyBoardSearchDto(orderByCol, query);
//        Page<StudyBoardDto> responseDto = boardService.findAllStudyBoardsByCategory(pageable, searchDto);
//        model.addAttribute("result", responseDto);
//        return "/index.html";
//    }

    @RequestMapping("/")
    public String hello(){
        return "/index.html";
    }

    @PostMapping("/test")
    public ResponseEntity<String> test(@RequestBody TestDto testDto){
        log.info(testDto.toString());
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }
}
