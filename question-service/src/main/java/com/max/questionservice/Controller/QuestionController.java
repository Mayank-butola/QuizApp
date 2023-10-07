package com.max.questionservice.Controller;


import com.max.questionservice.Models.question;
import com.max.questionservice.Models.questionWrapper;
import com.max.questionservice.Models.response;
import com.max.questionservice.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionService questionService;
    @Autowired
    Environment environment;

    @GetMapping("all")
    public ResponseEntity<List<question>> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("category/{Category}")
    public ResponseEntity<question> getQuestionByCategory(@PathVariable String Category) {
        return questionService.getQuestionByCategory(Category);
    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody question q) {
        return questionService.addQuestion(q);
    }

    @GetMapping("generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String category, @RequestParam int numberofQuestions) {
        return questionService.getQuestionsForQuiz(category, numberofQuestions);
    }

    @PostMapping("getQuestions")
    public ResponseEntity<List<questionWrapper>> getQuestions(@RequestBody List<Integer> questionIds) {
        System.out.println(environment.getProperty("local.server.port"));
        return questionService.getQuestions(questionIds);
    }

    @PostMapping("getScore")
    public ResponseEntity<Integer> getScore(List<response> responses){
        return questionService.getScore(responses);
    }
}
