package com.example.demo.service;

import com.example.demo.domain.dto.StudyBoardSearchRequestDto;
import com.example.demo.domain.dto.StudyBoardSearchResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudyBoardService {

    Page<StudyBoardSearchResponseDto> findAll(Pageable pageable, StudyBoardSearchRequestDto searchDto);


}
