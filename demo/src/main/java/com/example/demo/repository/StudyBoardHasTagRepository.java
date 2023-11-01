package com.example.demo.repository;

import com.example.demo.domain.StudyBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyBoardHasTagRepository extends JpaRepository<StudyBoardHasTagRepository, Long> {
}
