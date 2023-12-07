package com.example.demo.service;

import com.example.demo.domain.dto.StudyBoardSearchRequestDto;
import com.example.demo.domain.dto.StudyBoardSearchResponseDto;
import com.example.demo.repository.QStudyBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class StudyBoardServiceImpl implements StudyBoardService{

    private final QStudyBoardRepository qbr;


    @Transactional
    @Override
    public Page<StudyBoardSearchResponseDto> findAll(Pageable pageable, StudyBoardSearchRequestDto searchDto) {
        Page<StudyBoardSearchResponseDto> responseDto = qbr.findAll(pageable, searchDto);
        return responseDto;
    }
}
