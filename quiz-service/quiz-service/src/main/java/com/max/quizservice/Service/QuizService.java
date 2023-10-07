package com.max.quizservice.Service;

import com.max.quizservice.Dao.QuizDao;
import com.max.quizservice.Models.questionWrapper;
import com.max.quizservice.Models.quiz;
import com.max.quizservice.Models.quizDto;
import com.max.quizservice.Models.response;
import com.max.quizservice.feign.QuizInterface;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;
    @Autowired
    QuizInterface quizInterface;
    public ResponseEntity<String> CreateQuiz(String category, Integer no,String title) {
        List<Integer> questions = quizInterface.getQuestionsForQuiz(category,no).getBody();
        quiz quiz = new quiz();
        quiz.setTitle(title);
        quiz.setQuestionIds(questions);
        quizDao.save(quiz);
        return ResponseEntity.status(201).body("Success");
    }

    public ResponseEntity<List<questionWrapper>> getQuizQuestions(Integer id) {
        Optional<quiz> q = quizDao.findById(id);

        List<Integer> questionIds = q.get().getQuestionIds(); // Assuming getQuestionIds returns List<Integer>

        List<questionWrapper> questions = quizInterface.getQuestions(questionIds).getBody();

        return ResponseEntity.status(201).body(questions);
    }

    public ResponseEntity<Integer> getResult(Integer id, List<response> responses) {
        ResponseEntity<Integer> score = quizInterface.getScore(responses);

        return score;
    }
}
