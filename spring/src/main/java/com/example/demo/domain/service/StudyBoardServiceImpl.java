package com.example.demo.domain.service;

import com.example.demo.domain.dto.StudyBoardSearchRequestDto;
import com.example.demo.domain.dto.StudyBoardSearchResponseDto;
import com.example.demo.domain.exception.StudyBoardException;
import com.example.demo.domain.repository.StudyBoardRepository;
import com.example.demo.domain.repository.querydsl.QStudyBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class StudyBoardServiceImpl implements StudyBoardService{

    private final StudyBoardRepository sbr;
    private final QStudyBoardRepository qbr;

    @Transactional
    @Override
    public Page<StudyBoardSearchResponseDto> findAll(Pageable pageable, StudyBoardSearchRequestDto searchDto) {
        try{
            Page<StudyBoardSearchResponseDto> responseDto = qbr.findAll(pageable, searchDto);
            return responseDto;
        } catch (Exception e){
            e.printStackTrace();
            throw new StudyBoardException("필수 파라미터(open, orderby)를 입력하세요.", HttpStatus.BAD_REQUEST);
        }
    }
}
