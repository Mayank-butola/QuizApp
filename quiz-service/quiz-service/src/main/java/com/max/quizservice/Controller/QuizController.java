package com.max.quizservice.Controller;


import com.max.quizservice.Models.questionWrapper;
import com.max.quizservice.Models.quizDto;
import com.max.quizservice.Models.response;
import com.max.quizservice.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    QuizService quizService;
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestBody quizDto quiz){
        return quizService.CreateQuiz(quiz.getCategoryName(),quiz.getNumberofQuestions(),quiz.getTitle());
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<questionWrapper>> getQuizQuestions(@PathVariable Integer id){
        return quizService.getQuizQuestions(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> getResult(@PathVariable Integer id, @RequestBody List<response> responses){
        return quizService.getResult(id,responses);
    }
}
