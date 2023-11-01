package com.example.demo.controller;


import com.example.demo.domain.dto.StudyBoardDto;
import com.example.demo.domain.dto.StudyBoardSearchDto;
import com.example.demo.service.StudyBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/study")
public class StudyBoardController {

    private final StudyBoardService boardService;

    @GetMapping("/board")
    public String findAllStudyBoardsByCategory(Model model,
                                                                            @PageableDefault(size=10) Pageable pageable,
                                                                            @RequestParam(value="col",required=false) String orderByCol,
                                                                            @RequestParam(value="query", required=false) String query){
        StudyBoardSearchDto searchDto = new StudyBoardSearchDto(orderByCol, query);
        Page<StudyBoardDto> responseDto = boardService.findAllStudyBoardsByCategory(pageable, searchDto);
        model.addAttribute("result", responseDto);
        return "/index.html";
    }

//    @RequestMapping("/")
//    public String hello(){
//        return "/index.html";
//    }

}
