package com.project.quizapp.Service;

import com.project.quizapp.Dao.QuestionRepo;
import com.project.quizapp.Models.question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionRepo questionRepo;
    public ResponseEntity<List<question>> getAllQuestions() {
        try {
            List<question> questions = questionRepo.findAll();
        return ResponseEntity.ok(questions);
        }
        catch (Exception ex){
            ex.printStackTrace(); // Print the stack trace
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ArrayList<>());
        }

    }

    public ResponseEntity<question> getQuestionByCategory(String Category) {
        try {
            question foundQuestion = questionRepo.findByCategory(Category);
            if (foundQuestion != null) {
                return ResponseEntity.ok(foundQuestion);
            } else {
                return ResponseEntity.notFound().build(); // Return 404 if question is not found
            }
        } catch (Exception ex) {
            ex.printStackTrace(); // Print the stack trace
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    public ResponseEntity<String> addQuestion(question q) {
        questionRepo.save(q);
        return ResponseEntity.status(HttpStatus.CREATED).body("Success");
    }
}
