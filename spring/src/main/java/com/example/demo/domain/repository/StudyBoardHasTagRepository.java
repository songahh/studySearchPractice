package com.example.demo.domain.repository;

import com.example.demo.domain.entity.StudyBoardHasTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyBoardHasTagRepository extends JpaRepository<StudyBoardHasTag, Long> {
}