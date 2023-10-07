package com.project.quizapp.Dao;

import com.project.quizapp.Models.quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizDao extends JpaRepository<quiz,Integer> {
}
