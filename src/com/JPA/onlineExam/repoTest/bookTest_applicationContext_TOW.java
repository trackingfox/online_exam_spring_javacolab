package com.JPA.onlineExam.repoTest;

import java.io.FileNotFoundException;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.JPA.onlineExam.model.TestPaper;
import com.JPA.onlineExam.repository.QuestionRepository;
import com.JPA.onlineExam.repository.TestPaperRepository;
import com.JPA.onlineExam.repository.TopicRepository;
import com.JPA.onlineExam.service.QuestionService;
import com.JPA.onlineExam.service.TestPaperService_TOW;
import com.JPA.onlineExam.service.TopicService;

@EnableTransactionManagement
public class bookTest_applicationContext_TOW {
//	@Transactional
//	@Test
//	public void bookcall() {
//		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		BookService bookserv = (BookService) context.getBean("BookService");
//		bookserv.BookRun();
//	}

//	@Test
	@SuppressWarnings("resource")
	public void Papercall() throws IllegalStateException, FileNotFoundException {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		QuestionService questionService = context.getBean(QuestionService.class);
		questionService.populateQuestion();

		QuestionRepository questionrepo = context.getBean(QuestionRepository.class);
		System.out.println("************** PRINTING QUESTION (Randomly) *****************");
		System.out.println(questionrepo.fetchQuestions());
		System.out.println("-------------------------------------------------\n\n");

		TopicService topicservice = context.getBean(TopicService.class);
		topicservice.populateTopics();
//
		TopicRepository topicRepo = context.getBean(TopicRepository.class);
		System.out.println("************** PRINTING TOPIC (RANDOMLY *****************");
		System.out.println(topicRepo.FetchTopics());
		System.out.println("-------------------------------------------------\n\n");

		TestPaperService_TOW testpaperservice = context.getBean(TestPaperService_TOW.class);
		testpaperservice.populateTestPaper();

//		System.out.println(testpaperservice.getallTests());
//		TestPaperRepository testPaperRepo = context.getBean(TestPaperRepository.class);
//		System.out.println(testPaperRepo.fetchTestPapers());

	}

	@Test
//	@Transactional
	@SuppressWarnings("resource")
	public void pub() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//
		TestPaperRepository testPaperRepo = context.getBean(TestPaperRepository.class);
//		System.out.println(testPaperRepo.FetchTopics());
//		System.out.println(testPaperRepo.fetchQuestions());
//		System.out.println(testPaperRepo.fetchTestPapers());

//		Manually Fetch : Lazy fetch questionSet
//		List<TestPaper> lp = testPaperRepo.fetchTestPapers(); // requires: EntityGraphType.LOAD
//		List<TestPaper> lp = testPaperRepo.fetchTestPapers2(); // requires: EntityGraphType.LOAD
		List<TestPaper> lp = testPaperRepo.findAll();

		System.out.println(lp);
//		System.out.println("************** PRINTING TESTPAPERS (ALL) *****************");
//		for (TestPaper l : lp)
//			System.out.println("\n>>>> Topic:\t" + l.getTopics() + "\n>>>> Questions:\n" + l.getQuestionSet());

//		TestPaperService testpaperservice = context.getBean(TestPaperService.class);
		// lazy init error : findAll with mapping : need to add @EntityGraph etc.
//		List<TestPaper> pwd = testpaperservice.getallTests();

//
//		for (TestPaper t : testPaperRepo.fetchTestPapers()) {
//			System.out.println(t.getId() + "  " + t.getTestLevel() + " " + t.getTestName() + "  " + t.getQuestionSet()
//					+ "  " + t.getTopics());
//		}

//		ScoreService Score_service = context.getBean(ScoreService.class);
//		Score_service.populateScore();

//		AttemptedTestService Att_testpaperservice = context.getBean(AttemptedTestService.class);
//		Att_testpaperservice.populateAttemptedTestPaper();
//
//		TopicWiseScoreService topicWiseScoreService = context.getBean(TopicWiseScoreService.class);
//		topicWiseScoreService.populateTopicWiseScore();
//
//		UserService userService = context.getBean(UserService.class);
//		userService.populateUser();

	}

}
