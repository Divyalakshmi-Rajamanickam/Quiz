package com.github.divya.Quiz.service;

import com.github.divya.Quiz.repository.QuizQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizQuestionService {

    @Autowired
    private QuizQuestionRepository repository;

    public QuizQuestionService(QuizQuestionRepository repository) {
        this.repository = repository;
    }
}
