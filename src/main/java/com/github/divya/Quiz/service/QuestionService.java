package com.github.divya.Quiz.service;

import com.github.divya.Quiz.model.Question;
import com.github.divya.Quiz.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    public QuestionService(QuestionRepository repository) {
        this.questionRepository = repository;
    }

    public List<Question> getAllQuestion() {
        List<Question> questionList = new ArrayList<>();
        questionRepository.findAll().forEach(x -> questionList.add(x));
        return questionList;
    }

    public Question create(Question question) {
        Question questionCreated = questionRepository.save(question);
        return questionCreated;
    }

    public Question get(Integer id) {
        Optional<Question> potentialQuizQuestion = questionRepository.findById(id);
        Question question = potentialQuizQuestion.get();
        return question;
    }

    public Question update(Integer id, Question question) {
        Question questionInDataBase = get(id);
        Integer newQuestionId = question.getQuestionId();
        String newQuestion = question.getQuestion();
        String newAnswer1 = question.getAnswer1();
        String newAnswer2 = question.getAnswer2();
        String newAnswer3 = question.getAnswer3();
        String newAnswer4 = question.getAnswer4();
        Integer newQuestionLevel = question.getQuestionLevel();
        String newCorrectAnswer = question.getCorrectAnswer();

        questionInDataBase.setQuestion(newQuestion);
        questionInDataBase.setQuestionId(newQuestionId);
        questionInDataBase.setQuestionLevel(newQuestionLevel);
        questionInDataBase.setCorrectAnswer(newCorrectAnswer);
        questionInDataBase.setAnswer1(newAnswer1);
        questionInDataBase.setAnswer2(newAnswer2);
        questionInDataBase.setAnswer3(newAnswer3);
        questionInDataBase.setAnswer4(newAnswer4);
        questionRepository.save(questionInDataBase);
        return questionInDataBase;
    }

    public Question delete(Integer id) {
        Question question = get(id);
        questionRepository.delete(question);
        return question;
    }
}
