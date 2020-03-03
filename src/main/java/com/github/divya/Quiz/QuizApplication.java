package com.github.divya.Quiz;

import com.github.divya.Quiz.model.Question;
import com.github.divya.Quiz.model.Quiz;
import com.github.divya.Quiz.model.QuizQuestion;
import com.github.divya.Quiz.model.User;
import com.github.divya.Quiz.repository.QuestionRepository;
import com.github.divya.Quiz.repository.QuizQuestionRepository;
import com.github.divya.Quiz.repository.QuizRepository;
import com.github.divya.Quiz.repository.UserRepository;
import com.github.divya.Quiz.service.QuestionService;
import com.github.divya.Quiz.service.QuizQuestionService;
import com.github.divya.Quiz.service.QuizService;
import com.github.divya.Quiz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuizApplication implements CommandLineRunner {
	@Autowired
	private QuizRepository quizRepository;
	private QuestionRepository questionRepository;
	private QuizQuestionRepository qqRepository;
	private UserRepository userRepository;

	public QuizApplication(QuizRepository quizRepository, QuestionRepository questionRepository,
						   QuizQuestionRepository qqRepository, UserRepository userRepository) {
		this.quizRepository = quizRepository;
		this.questionRepository = questionRepository;
		this.qqRepository = qqRepository;
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(QuizApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User(1, "userOne", "password", "User", "One", "u.one@email.com", "parent");
		User user2 = new User(2, "userTwo", "password", "User", "Two", "u.two@email.com", "teacher");
		User user3 = new User(3, "userThree", "password", "User", "Three", "u.three@email.com", "parent");
		User user4 = new User(4, "userFour", "password", "User", "Four", "u.four@email.com", "parent");
		User user5 = new User(5, "userFive", "password", "User", "Five", "u.five@email.com", "teacher");
		User user6 = new User(6, "userSix", "password", "User", "Six", "u.six@email.com", "parent");
		User will = new User(7, "w.ancona", "password", "Will", "Ancona", "w.ancona@email.com", "parent");

		userRepository.save(user1);
		userRepository.save(user2);
		userRepository.save(user3);
		userRepository.save(user4);
		userRepository.save(user5);
		userRepository.save(user6);
		userRepository.save(will);


		Question question1 = new Question(1,"What is 9+3?","8","30","12","4",0,"12");
		Question question2 = new Question(2,"What color is the apple?","Yellow","Red","Purple","Blue",0,"Red");
		Question question3 = new Question(3,"What color word is spelled right?","Bu","Blo","Blue","Blu",0,"Blue");
		Question question4 = new Question(4,"What is 3-2?","45","8","1","0",0,"1");
		Question question5 = new Question(5,"Select the missing letter U,V,W,__,Y,Z?","A","T","X","E",0,"X");

		questionRepository.save(question1);
		questionRepository.save(question2);
		questionRepository.save(question3);
		questionRepository.save(question4);
		questionRepository.save(question5);

		Quiz quiz1 = new Quiz(01,null,1);
		Quiz quiz5 = new Quiz(05,null,2);
		Quiz quiz2 = new Quiz(02,null,2);
		Quiz quiz3 = new Quiz(03,null,3);
		Quiz quiz4 = new Quiz(04,null,4);

		quizRepository.save(quiz1);
		quizRepository.save(quiz2);
		quizRepository.save(quiz3);
		quizRepository.save(quiz4);
		quizRepository.save(quiz5);

		QuizQuestion qq1 = new QuizQuestion(01, 2,1, false, "4");
		QuizQuestion qq2 = new QuizQuestion(02, 4,3, true, "Blue");
		QuizQuestion qq3 = new QuizQuestion(03, 3,2, false, "Purple");
		QuizQuestion qq4 = new QuizQuestion(04, 1,4, true, "1");
		QuizQuestion qq5 = new QuizQuestion(05, 2,1, true, "12");

		qqRepository.save(qq1);
		qqRepository.save(qq2);
		qqRepository.save(qq3);
		qqRepository.save(qq4);
		qqRepository.save(qq5);

	}
}
