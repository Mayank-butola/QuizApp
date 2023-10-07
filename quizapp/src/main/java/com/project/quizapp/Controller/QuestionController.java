package com.project.quizapp.Controller;

import com.project.quizapp.Models.question;
import com.project.quizapp.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionService questionService;
    @GetMapping("all")
    public ResponseEntity<List<question>> getAllQuestions(){
       return questionService.getAllQuestions();
    }

    @GetMapping("category/{Category}")
    public ResponseEntity<question> getQuestionByCategory(@PathVariable String Category){
        return questionService.getQuestionByCategory(Category);
    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody question q){
        return questionService.addQuestion(q);
    }
}
