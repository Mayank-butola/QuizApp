package com.project.quizapp.Service;

import com.project.quizapp.Dao.QuestionRepo;
import com.project.quizapp.Dao.QuizDao;
import com.project.quizapp.Models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;
    @Autowired
    QuestionRepo questionRepo;
    public ResponseEntity<String> CreateQuiz(String category, String title, int no) {
        List<question> quesitons = questionRepo.findRandomQuestionsByCategory(category,no);
        quiz q = new quiz();
        q.setTitle(title);
        q.setQuestions(quesitons);
        quizDao.save(q);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<questionWrapper>> getQuizQuestions(Integer id) {
        Optional<quiz> q = quizDao.findById(id);
        List<question> questions= q.get().getQuestions();
        List<questionWrapper> questionforusers = new ArrayList<>();
        for(question it : questions){
            questionWrapper foruser = new questionWrapper(it.getId(),it.getOption1(),it.getOption2(), it.getOption3(), it.getOption4(),it.getQuestionTitle());
            questionforusers.add(foruser);
        }
        return ResponseEntity.status(201).body(questionforusers);
    }

    public ResponseEntity<Integer> getResult(Integer id, List<response> responses) {
        quiz q = quizDao.findById(id).get();
        List<question> questions = q.getQuestions();
        int score = 0;
        int i = 0;
        for(response it : responses){
            if(it.getResponse().equals(questions.get(i).getRightAnswer())){
                score++;
            }
            i++;
        }
        return ResponseEntity.status(200).body(score);
    }
}
