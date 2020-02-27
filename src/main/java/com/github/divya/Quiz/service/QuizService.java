package com.github.divya.Quiz.service;

import com.github.divya.Quiz.model.Quiz;
import com.github.divya.Quiz.model.User;
import com.github.divya.Quiz.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {
    @Autowired
    private QuizRepository repository;

    public QuizService(QuizRepository repository) {
        this.repository = repository;
    }

    public List<User> getAllQuizzes() {
        return null;
    }

    public Object create(Quiz quiz) {
        return null;
    }

    public Quiz get(Integer id) {
        return null;
    }

    public Quiz update(Integer id, Quiz quiz) {
        return null;
    }

    public Quiz delete(Integer id) {
        return null;
    }
}
