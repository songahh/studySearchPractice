package com.example.demo.repository;

import com.example.demo.domain.StudyBoardHasTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyBoardHasTagRepository extends JpaRepository<StudyBoardHasTag, Long> {
}
