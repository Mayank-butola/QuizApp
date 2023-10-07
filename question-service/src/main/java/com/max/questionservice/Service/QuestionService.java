package com.max.questionservice.Service;

import com.max.questionservice.Dao.QuestionRepo;
import com.max.questionservice.Models.question;
import com.max.questionservice.Models.questionWrapper;
import com.max.questionservice.Models.response;
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

    public ResponseEntity<List<Integer>> getQuestionsForQuiz(String category, int numberofQuestions){
        List<Integer> questions = questionRepo.findRandomQuestionsByCategory(category,numberofQuestions);
        return ResponseEntity.ok(questions);

    }

    public ResponseEntity<List<questionWrapper>> getQuestions(List<Integer> questionIds) {
        List<questionWrapper> wrappers= new ArrayList<>();
        List<question> questions = questionRepo.findAllById(questionIds);
        for(var it : questions){
            questionWrapper q = new questionWrapper();
            q.setId(it.getId());
            q.setQuestionTitle((it.getQuestionTitle()));
            q.setOption1(it.getOption1());
            q.setOption2(it.getOption2());
            q.setOption3(it.getOption3());
            q.setOption4(it.getOption4());
            wrappers.add(q);
        }
        return ResponseEntity.ok(wrappers);
    }

    public ResponseEntity<Integer> getScore(List<response> responses) {

        int score = 0;
        for(var it : responses){
            if(it.getResponse().equals(questionRepo.findById(it.getId()).get().getRightAnswer())){
                score++;
            }
        }
        return ResponseEntity.ok(score);
    }
}
