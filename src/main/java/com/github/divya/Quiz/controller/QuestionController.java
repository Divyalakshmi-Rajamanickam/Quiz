package com.github.divya.Quiz.controller;

import com.github.divya.Quiz.model.Question;
import com.github.divya.Quiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<Question>> getAllQuestions(){
        System.out.println("QuestionController.getAllQuestions");
        List<Question> responseBody = questionService.getAllQuestion();
        ResponseEntity responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(value="/create", method= RequestMethod.POST)
    public  ResponseEntity<Question> create(@RequestBody Question question){
        Question responseBody = (Question) questionService.create(question);
        ResponseEntity responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
        return responseEntity;
    }


    @RequestMapping(value = "/read/{id}", method = RequestMethod.GET)
    public ResponseEntity<Question> get(@PathVariable Integer id) {
        Question responseBody = questionService.get(id);
        ResponseEntity responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
        return  responseEntity;
    }


    @RequestMapping(value="/update/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Question> update(@PathVariable Integer id, @RequestBody Question user){
        Question responseBody = questionService.update(id,user);
        ResponseEntity responseEntity = new ResponseEntity<>(responseBody,HttpStatus.OK);
        return responseEntity;
    }


    @RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Question> delete(@PathVariable Integer id){
        Question responseBody = questionService.delete(id);
        ResponseEntity responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
        return responseEntity;
    }
}
