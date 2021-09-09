package com.JPA.onlineExam.repoTest;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.JPA.onlineExam.model.TestPaper;
import com.JPA.onlineExam.model.User;
import com.JPA.onlineExam.repository.QuestionRepository;
import com.JPA.onlineExam.repository.TestPaperRepository;
import com.JPA.onlineExam.repository.TopicRepository;
import com.JPA.onlineExam.repository.UserRepository;
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

//	@Test
//	@Transactional
	@SuppressWarnings("resource")
	public void TestRepoTest() {
		Set<TestPaper> ls;
		List<TestPaper> ll;
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//
		TestPaperRepository testPaperRepo = context.getBean(TestPaperRepository.class);
//		System.out.println(testPaperRepo.FetchTopics());
//		System.out.println(testPaperRepo.fetchQuestions());
//		System.out.println(testPaperRepo.fetchTestPapers());

//		Manually Fetch : Lazy fetch questionSet

//		List<TestPaper> lp;
//		List<TestPaper> lp = testPaperRepo.fetchTestPapers2(); // requires: EntityGraphType.LOAD
//		List<TestPaper> lp = testPaperRepo.findAll(); //# Working 

//		List<TestPaper> lp;
//		lp = testPaperRepo.fetchTestPaperQuestions(); // # Working
////		System.out.println(lp);
//		System.out.println("************** PRINTING TESTPAPERS (QA) *****************");
//		System.out.println("# of papers" + lp.size());
//		for (TestPaper l : lp) {
//
//			System.out.println("\n>>>>Test Paper:" + l.getId() + "\n>>>> Questions:" + l.getQuestionSet().size()
//					+ "\n>>>> Questions/Answers:");
//			Set<Question> QA = l.getQuestionSet();
//			for (Question Q : QA)
//				System.out.println(Q.toString());
//
//		}

//		Set<TestPaper> ld = testPaperRepo.fetchTestPapers(); // requires: EntityGraphType.LOAD
//		System.out.println("************** PRINTING TESTPAPERS (ALL) *****************");
//		for (TestPaper l : ld) {
//			System.out.println("\n>>>> Topic:\t" + l.getTopics() + "\n>>>> Questions:\n" + l.getQuestionSet().size()
//					+ "\n>>>> Questions/Answers:");
//			Set<Question> QA = l.getQuestionSet();
//			for (Question Q : QA)
//				System.out.println(Q.QuestionsText());
//			// System.out.println(Q.toString()); // will not work if
//		}

//		Set<TestPaper> lp = testPaperRepo.fetchTestPapersTopics();
//		System.out.println("************** PRINTING TESTPAPERS (TOPICS) *****************");
//		for (TestPaper l : lp)
//			System.out.println("\n>>>> Topic:\t" + l.getTopics());

		System.out.println("************** PRINTING TESTPAPERS (ALL) *****************");
		for (TestPaper t : testPaperRepo.fetchTestPapers()) {
			System.out.println("Test #" + t.getId() + "  " + t.getTestLevel() + " " + t.getTestName() + "  " + "  "
					+ t.getTopics());
			t.getQuestionSet().forEach(x -> System.out.println(x.QuestionsText()));
		}

	}

	@Test
//	@Transactional
	@SuppressWarnings("resource")
	public void UserRepoTest() {
		Set<TestPaper> ls;
		List<TestPaper> ll;
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		UserRepository userRepo = context.getBean(UserRepository.class);
		List<User> queryUsers;

//		 Get Friends of the users from Is {2,8}
		queryUsers = userRepo.fetchUsersFriends();
		for (User u : queryUsers) {
			Set<User> fList = u.getFriends();
			System.out.println("\n>>>>>>>>>>>>User #" + u.getUserName() + "\t has friends =" + fList.size());
			fList.forEach(x -> System.out.println(x.getUserName()));
		}

////		 Get Test Paper of the users from Is {2,8}
//		queryUsers = userRepo.fetchUsersTestpaper();
//		for (User u : queryUsers) {
//			Set<TestPaper> fList = u.getTestPaperList();
//			System.out.println("\n>>>>>>>>>>>>User #" + u.getUserName() + "\t TestPaper Count =" + fList.size());
//			fList.forEach(x -> System.out.println(x.getId() + " | " + x.getTestName() + "|"));
//		}

////		 Get Test Paper with Topics,   of the users from Is {2,8}
//		queryUsers = userRepo.fetchUsersTestpaperTopics();
//		for (User u : queryUsers) {
//			Set<TestPaper> fList = u.getTestPaperList();
//			System.out.println("\n>>>>>>>>>>>>User #" + u.getUserName() + "\t TestPaper Count =" + fList.size());
//			fList.forEach(x -> System.out.println(x.getId() + " | " + x.getTestName() + "|" + x.getTopics()));
//		}

////		 Get Test Paper with Topics, Questions    of the users from Is {2,8}
//		queryUsers = userRepo.fetchUserTestpaperQuestionsTopics(1, 2);
//		for (User u : queryUsers) {
//			Set<TestPaper> tList = u.getTestPaperList();
//			System.out.println("\n>>>>>>>>>>>>User #" + u.getUserName() + "\t TestPaper Count =" + tList.size());
//
//			// only filter first 2 elements of the testpaper set.
//			tList.stream()
//					.limit(2)
//					.forEach(t -> {
//						System.out.println(t.getId() + " | " + t.getTestName() + "|" + t.getTopics() + "\n Questions:");
//						t.getQuestionSet().forEach(
//								q -> System.out.println("T[" + t.getId() + "] Q[" + q.getId() + "]:> " + q
//										.getQuestion()));
//					});
//		}

//			Simple Query by User ID : Get Test Paper with Topics, Questions  of the users from Is {2,8}
		User u = userRepo.fetchAUserTestpaperQuestionsTopics(5);
		Set<TestPaper> tList = u.getTestPaperList();

		System.out.println(u.getUserName());

		TestPaper t = tList.iterator().next();
		System.out.println(t.getId() + " | " + t.getTestName() + "|" + "\n Questions:");
		t.getQuestionSet()
				.forEach(q -> System.out.println("T[" + t.getId() + "] Q[" + q.getId() + "]:> " + q.getQuestion()));

	}

}
