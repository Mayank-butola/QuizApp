package com.max.quizservice.Dao;

import com.max.quizservice.Models.quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizDao extends JpaRepository<quiz,Integer> {
}
