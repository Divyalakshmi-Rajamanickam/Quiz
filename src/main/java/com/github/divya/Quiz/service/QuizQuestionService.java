package com.github.divya.Quiz.service;

import com.github.divya.Quiz.model.QuizQuestion;
import com.github.divya.Quiz.model.User;
import com.github.divya.Quiz.repository.QuizQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizQuestionService {

    @Autowired
    private QuizQuestionRepository quizQuestionRepository;

    public QuizQuestionService(QuizQuestionRepository repository) {
        this.quizQuestionRepository = repository;
    }

    public List<QuizQuestion> getAllQuizQuestions() {
        List<QuizQuestion> quizQuestionList = new ArrayList<>();
        quizQuestionRepository.findAll().forEach(x -> quizQuestionList.add(x));
        return quizQuestionList;
    }

    public QuizQuestion create(QuizQuestion quizQuestion) {
        QuizQuestion quizQuestionCreated = quizQuestionRepository.save(quizQuestion);
        return quizQuestionCreated;
    }

    public QuizQuestion get(Integer id) {
        Optional<QuizQuestion> potentialQuizQuestion = quizQuestionRepository.findById(id);
        QuizQuestion quizQuestion = potentialQuizQuestion.get();
        return quizQuestion;
    }

    public QuizQuestion update(Integer id, QuizQuestion quizQuestion) {
        QuizQuestion quizQuestionInDataBase = get(id);
        Integer newQuizId = quizQuestion.getQuizId();
        Integer newQuestionId = quizQuestion.getQuestionId();
        Integer newQuestionNumber = quizQuestion.getQuestionNumber();
        String newUserAnswer = quizQuestion.getUserAnswer();
        boolean newIsCorrect = quizQuestion.isCorrect();

        quizQuestionInDataBase.setQuizId(newQuizId);
        quizQuestionInDataBase.setQuestionId(newQuestionId);
        quizQuestionInDataBase.setQuestionNumber(newQuestionNumber);
        quizQuestionInDataBase.setUserAnswer(newUserAnswer);
        quizQuestionInDataBase.setCorrect(newIsCorrect);
        quizQuestionRepository.save(quizQuestionInDataBase);
        return quizQuestionInDataBase;
    }

    public QuizQuestion delete(Integer id) {
        QuizQuestion quizQuestion = get(id);
        quizQuestionRepository.delete(quizQuestion);
        return quizQuestion;
    }


}
