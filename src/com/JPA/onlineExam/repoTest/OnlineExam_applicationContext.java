package com.JPA.onlineExam.repoTest;

import java.io.FileNotFoundException;
import java.util.Optional;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.JPA.onlineExam.model.TestPaper;
import com.JPA.onlineExam.repository.QuestionRepository;
import com.JPA.onlineExam.repository.TestPaperRepository;
import com.JPA.onlineExam.repository.TopicRepository;
import com.JPA.onlineExam.repository.TopicWiseScoreRepository;
import com.JPA.onlineExam.repository.UserRepository;
import com.JPA.onlineExam.service.AttemptedTestService;
import com.JPA.onlineExam.service.QuestionService;
import com.JPA.onlineExam.service.ScoreService;
import com.JPA.onlineExam.service.TestPaperService;
import com.JPA.onlineExam.service.TopicWiseScoreService;
import com.JPA.onlineExam.service.UserService;

public class OnlineExam_applicationContext {

//	@Transactional
	@Test
	public void TestPapercall() throws IllegalStateException, FileNotFoundException {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

//		QuestionService questionService = context.getBean(QuestionService.class);
//		// questionService.populateQuestion();
//		questionService.populateQuestionWithTopics();
//		QuestionRepository questionrepo = context.getBean(QuestionRepository.class);
//		System.out.println(questionrepo.fetchQuestions());

//		TopicService topicservice = context.getBean(TopicService.class);
//		topicservice.populateTopics();

//		TopicRepository topicRepo = context.getBean(TopicRepository.class);
//		System.out.println(topicRepo.FetchTopics());

		TestPaperService testpaperservice = context.getBean(TestPaperService.class);
//		testpaperservice.populateTestPaper();
		testpaperservice.generateOneTestPaper(); // generate one test paper

		// Print testpaper by ID that we entered
		TestPaperRepository testPaperRepo = context.getBean(TestPaperRepository.class);
		Optional<TestPaper> tp = testPaperRepo.findById((long) 9);
		tp.get().getQuestionSet()
				.forEach(y -> {
					System.out.println(y.QuestionsText());
				});

//		System.out.println(testPaperRepo.fetchTestPapers());
//
//		ScoreService Score_service = context.getBean(ScoreService.class);
//		Score_service.populateScore();
//
//		AttemptedTestService Att_testpaperservice = context.getBean(AttemptedTestService.class);
//		Att_testpaperservice.populateAttemptedTestPaper();
//
////		AttemptedTestRepository Att_testRepo = context.getBean(AttemptedTestRepository.class);
////		System.out.println(Att_testRepo.FetchAttemptedTestPaper1(1, 20));
//
//		TopicWiseScoreService topicWiseScoreService = context.getBean(TopicWiseScoreService.class);
//		topicWiseScoreService.populateTopicWiseScore();
//
////		TopicWiseScoreRepository topicWiseScoreRepo = context.getBean(TopicWiseScoreRepository.class);
////		System.out.println(topicWiseScoreRepo.Fetch_TopicWiseScoreList(1, 3));
//
//		UserService userService = context.getBean(UserService.class);
//		userService.populateUser();
//		userService.populateFriends();

//		UserRepository userRepo = context.getBean(UserRepository.class);
//		System.out.println(userRepo.FetchUserFinal().toString());

	}

//	@Test
	public void InitializeDataBaseAndTestIO() throws IllegalStateException, FileNotFoundException {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		QuestionService questionService = context.getBean(QuestionService.class);
		// questionService.populateQuestion();
		questionService.populateQuestionWithTopics();

		QuestionRepository questionrepo = context.getBean(QuestionRepository.class);
		System.out.println(questionrepo.fetchQuestions());

////		TopicService topicservice = context.getBean(TopicService.class); // Redundant - DONOT USE 
////		topicservice.populateTopics();	// Redundant - DONOT USE 

		TopicRepository topicRepo = context.getBean(TopicRepository.class);
		System.out.println(topicRepo.FetchTopics()); // OR use findAll()

		TestPaperService testpaperservice = context.getBean(TestPaperService.class);
		testpaperservice.populateTestPaper();

		// Print testpaper and questions
		TestPaperRepository testPaperRepo = context.getBean(TestPaperRepository.class);
//		System.out.println(testPaperRepo.fetchTestPapers()); // wont work // lazy
		testPaperRepo.fetchTestPapers()
				.stream()
				.limit(2)
				.forEach(x -> {
					System.out.println("Test #" + x.getId());
					x.getQuestionSet()
							.forEach(y -> {
								System.out.println(y.QuestionsText());
							});
				});

		ScoreService Score_service = context.getBean(ScoreService.class);
		Score_service.populateScore();

		AttemptedTestService Att_testpaperservice = context.getBean(AttemptedTestService.class);
		Att_testpaperservice.populateAttemptedTestPaper();

//////		AttemptedTestRepository Att_testRepo = context.getBean(AttemptedTestRepository.class);
//////		System.out.println(Att_testRepo.FetchAttemptedTestPaper1(1, 20));

		TopicWiseScoreService topicWiseScoreService = context.getBean(TopicWiseScoreService.class);
		topicWiseScoreService.populateTopicWiseScore();

		// Just a normal fetch
		TopicWiseScoreRepository topicWiseScoreRepo = context.getBean(TopicWiseScoreRepository.class);
		System.out.println(topicWiseScoreRepo.Fetch_TopicWiseScoreList(1, 3));

		UserService userService = context.getBean(UserService.class);
		userService.populateUser(); // added unique to username
		userService.populateFriends();

		UserRepository userRepo = context.getBean(UserRepository.class);
//		System.out.println(userRepo.FetchUserFinal().toString());// error // cannot print all at once. 
//		userRepo.FetchUserFinal() // will throw memory full usage
		System.out.println("***************** Printing user names *****************");
		userRepo.findAll()
				.forEach(x -> {
					System.out.print(x.getUserName() + ",");
				});
	}

//	@Test
	public void OtherCalls() throws IllegalStateException, FileNotFoundException {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

//		AttemptedTestRepository Att_testRepo = context.getBean(AttemptedTestRepository.class);
//		System.out.println(Att_testRepo.FetchAttemptedTestPaper1(1, 20));
	}
}
