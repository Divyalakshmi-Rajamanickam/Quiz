package com.github.divya.Quiz.service;

import com.github.divya.Quiz.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizService {
    @Autowired
    private QuizRepository repository;

    public QuizService(QuizRepository repository) {
        this.repository = repository;
    }
}
