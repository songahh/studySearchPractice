package com.example.demo.repository;

import com.example.demo.domain.StudyBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyBoardRepository extends JpaRepository<StudyBoard, Long> {

}
