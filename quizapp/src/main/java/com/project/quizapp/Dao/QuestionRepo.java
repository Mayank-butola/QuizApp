package com.project.quizapp.Dao;

import com.project.quizapp.Models.question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepo extends JpaRepository<question,Integer> {
    question findByCategory(String Category);

    @Query(value = "SELECT * FROM question q WHERE q.category=:category ORDER BY RANDOM() LIMIT :no", nativeQuery = true)
    List<question> findRandomQuestionsByCategory(String category, int no);
}
