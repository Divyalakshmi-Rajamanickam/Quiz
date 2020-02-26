package com.github.divya.Quiz.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class QuizQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer quizId;
    private Integer questionId;
    private Integer questionNumber;
    private boolean isCorrect;
    private String userAnswer;

    public QuizQuestion(Integer quizId, Integer questionId, Integer questionNumber,
                        boolean isCorrect, String userAnswer) {
        this.quizId = quizId;
        this.questionId = questionId;
        this.questionNumber = questionNumber;
        this.isCorrect = isCorrect;
        this.userAnswer = userAnswer;
    }

    public Integer getQuizId() {
        return quizId;
    }

    public void setQuizId(Integer quizId) {
        this.quizId = quizId;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(Integer questionNumber) {
        this.questionNumber = questionNumber;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }

    public QuizQuestion() {
    }

    @Override
    public String toString() {
        return "QuizQuestion{" +
                "quizId=" + quizId +
                ", questionId=" + questionId +
                ", questionNumber=" + questionNumber +
                ", isCorrect=" + isCorrect +
                ", userAnswer='" + userAnswer + '\'' +
                '}';
    }
}
