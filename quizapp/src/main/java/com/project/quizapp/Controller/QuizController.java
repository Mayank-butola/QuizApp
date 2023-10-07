package com.project.quizapp.Controller;

import com.project.quizapp.Models.questionWrapper;
import com.project.quizapp.Models.response;
import com.project.quizapp.Service.QuizService;
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
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam String title, @RequestParam int no){
        return quizService.CreateQuiz(category,title,no);
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
