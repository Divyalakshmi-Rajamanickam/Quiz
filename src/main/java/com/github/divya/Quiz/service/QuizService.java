package com.github.divya.Quiz.service;

import com.github.divya.Quiz.model.Quiz;
import com.github.divya.Quiz.model.User;
import com.github.divya.Quiz.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    private QuizRepository quizRepository;

    public QuizService(QuizRepository repository) {
        this.quizRepository = repository;
    }

    public List<Quiz> getAllQuizzes() {
        List<Quiz> quizList = new ArrayList<>();
        quizRepository.findAll().forEach(x -> quizList.add(x));
        return quizList;
    }

    public Quiz create(Quiz quiz) {
        Quiz quizCreated = quizRepository.save(quiz);
        return quizCreated;
    }

    public Quiz get(Integer id) {
        Optional<Quiz> potentialUser = quizRepository.findById(id);
        Quiz quiz = potentialUser.get();
        return quiz;
    }

    public Quiz update(Integer id, Quiz quiz) {
        Quiz quizInDataBase = get(id);
        Integer newScore = quiz.getScore();
        Integer newUserId = quiz.getUserId();

        quizInDataBase.setScore(newScore);
        quizInDataBase.setUserId(newUserId);
        return quizInDataBase;
    }

    public Quiz delete(Integer id) {
        Quiz quiz = get(id);
        quizRepository.delete(quiz);
        return quiz;
    }
    }

