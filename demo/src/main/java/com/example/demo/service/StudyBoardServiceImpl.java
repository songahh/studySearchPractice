package com.example.demo.service;

import com.example.demo.domain.dto.StudyBoardDto;
import com.example.demo.domain.dto.StudyBoardSearchDto;
import com.example.demo.repository.QStudyBoardRepository;
import com.example.demo.repository.StudyBoardRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class StudyBoardServiceImpl implements StudyBoardService{

    private final QStudyBoardRepository boardRepository;

    @Transactional
    @Override
    public Page<StudyBoardDto> findAllStudyBoardsByCategory(Pageable pageable, StudyBoardSearchDto searchDto) {
        Page<StudyBoardDto> responseDto = boardRepository.findAllStudyBoardsByCategory(pageable, searchDto);
        return responseDto;
    }

}
