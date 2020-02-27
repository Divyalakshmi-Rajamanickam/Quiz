package com.github.divya.Quiz.controller;


import com.github.divya.Quiz.model.QuizQuestion;
import com.github.divya.Quiz.model.User;
import com.github.divya.Quiz.service.QuizQuestionService;
import com.github.divya.Quiz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quizQuestion")
public class QuizQuestionController {
    @Autowired
    private QuizQuestionService quizQuestionService;

    public QuizQuestionController(QuizQuestionService quizQuestionService) {
        this.quizQuestionService = quizQuestionService;
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<QuizQuestion>> getAllQuizQuestions(){
        System.out.println("quizQuestionController.getAllQuizQuestion");
        List<QuizQuestion> responseBody = quizQuestionService.getAllQuizQuestions();
        ResponseEntity responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(value="/create", method= RequestMethod.POST)
    public  ResponseEntity<QuizQuestion> create(@RequestBody QuizQuestion quizQuestion){
        QuizQuestion responseBody = (QuizQuestion) quizQuestionService.create(quizQuestion);
        ResponseEntity responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
        return responseEntity;
    }


    @RequestMapping(value = "/read/{id}", method = RequestMethod.GET)
    public ResponseEntity<QuizQuestion> get(@PathVariable Integer id) {
        QuizQuestion responseBody = quizQuestionService.get(id);
        ResponseEntity responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
        return  responseEntity;
    }


    @RequestMapping(value="/update/{id}", method=RequestMethod.PUT)
    public ResponseEntity<QuizQuestion> update(@PathVariable Integer id, @RequestBody QuizQuestion quizQuestion){
        QuizQuestion responseBody = quizQuestionService.update(id,quizQuestion);
        ResponseEntity responseEntity = new ResponseEntity<>(responseBody,HttpStatus.OK);
        return responseEntity;
    }


    @RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<QuizQuestion> delete(@PathVariable Integer id){
        QuizQuestion responseBody = quizQuestionService.delete(id);
        ResponseEntity responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
        return responseEntity;
    }
}
