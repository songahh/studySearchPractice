package com.example.demo.service;

import com.example.demo.domain.dto.StudyBoardDto;
import com.example.demo.domain.dto.StudyBoardSearchDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudyBoardService {

    Page<StudyBoardDto> findAllStudyBoardsByCategory(Pageable pageable, StudyBoardSearchDto searchDto);
}
