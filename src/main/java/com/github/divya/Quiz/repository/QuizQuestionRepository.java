package com.github.divya.Quiz.repository;

import com.github.divya.Quiz.model.QuizQuestion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizQuestionRepository extends CrudRepository<QuizQuestion, Integer> {
}
