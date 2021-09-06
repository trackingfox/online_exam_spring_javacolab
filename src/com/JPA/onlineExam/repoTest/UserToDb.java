//package com.JPA.onlineExam.repoTest;
//
//import java.io.FileNotFoundException;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//import javax.persistence.Query;
//
//import org.junit.Test;
//
//import com.JPA.onlineExam.model.AttemptedTest;
//import com.JPA.onlineExam.model.Question;
//import com.JPA.onlineExam.model.Score;
//import com.JPA.onlineExam.model.TestPaper;
//import com.JPA.onlineExam.model.Topic;
//import com.JPA.onlineExam.model.TopicWiseScore;
//import com.JPA.onlineExam.model.User;
//
//public class UserToDb {
//	@Test
//	public void userToDb() throws IllegalStateException, FileNotFoundException {
//
//		// Get entity Manager
//		myEntityManager M = new myEntityManager();
//		EntityManager em = M.getentitymanager();
//		// You should create entity manger and factory ONLY ONCE.
//		// Each creation will regenerate database and wipe out data with 'create' option
//		// in persistence.xml
//
//		// import all question to database
//		QuesCsv2db_Insert ques = new QuesCsv2db_Insert();
//		ques.importTodb(em);
//
//		// import some topics
//		generateTopics(em);
//
////		// Generate tests with random questions		
//		generateTestPaper(em); // generate 4 tests
////
////		
////
//		generateScores(em);
//
//		// Generate some 'fake' attempted tests
//		createAttemptedTest(em); // sample attempt 1
//
//		// set scoreId in attempted test
//		// setScoreIdAttemptedTest(em);
//
//		createTopicWiseScore(em);
//
//		// Gererate users
//		createUser(em);
//
//		M.closeAll(); // remember to close the connection
//	}
//
//	public void generateScores(EntityManager em) {
//		em.getTransaction().begin();
//
//		Score score1 = new Score();
//		Score score2 = new Score();
//		Score score3 = new Score();
//		Score score4 = new Score();
//		Score score5 = new Score();
//		Score score6 = new Score();
//		Score score7 = new Score();
//		Score score8 = new Score();
//		Score score9 = new Score();
//
//		score1.setScore(56);
//		score1.setPercentile(78);
//		em.merge(score1);
//
//		score2.setScore(87);
//		score2.setPercentile(99);
//		em.merge(score2);
//
//		score3.setScore(72);
//		score3.setPercentile(90);
//		em.merge(score3);
//
//		score4.setScore(75);
//		score4.setPercentile(93);
//		em.merge(score4);
//
//		score5.setScore(76);
//		score5.setPercentile(94);
//		em.merge(score5);
//
//		score6.setScore(67);
//		score6.setPercentile(82);
//		em.merge(score6);
//
//		score7.setScore(60);
//		score7.setPercentile(80);
//		em.merge(score7);
//
//		score8.setScore(59);
//		score8.setPercentile(70);
//		em.merge(score8);
//
//		score9.setScore(59);
//		score9.setPercentile(70);
//		em.merge(score9);
//
//		em.getTransaction().commit();
//
//	}
//
//	public void generateTopics(EntityManager em) {
//
//		em.getTransaction().begin();
//
//		Topic topic1 = new Topic();
//		Topic topic2 = new Topic();
//		Topic topic3 = new Topic();
////		Topics topic4 = new Topics();
////		Topics topic5 = new Topics();
////		Topics topic6 = new Topics();
//
//		// List<TestPaper> testPapers = FetchTestpaper(em);
//		// System.out.println("sfjs=" + testPapers.size());
//
//		// topic1.setTestPapers(testPapers);
//		topic1.setContent("Hello content");
//		topic1.setTitletopic("afjfajfl");
//		em.merge(topic1);
//
//		// testPapers = FetchTestpaper(em);
//
//		// topic2.setTestPapers(testPapers);
//		topic2.setContent("Pqljjv");
//		topic2.setTitletopic("vnsdnlsl");
//		em.merge(topic2);
//
//		// testPapers = FetchTestpaper(em);
//
//		// topic3.setTestPapers(testPapers);
//		topic3.setContent("gdgdgdlk");
//		topic3.setTitletopic("sjsljlskjglk");
//		em.merge(topic3);
//
//		em.getTransaction().commit();
//
//	}
//
//	/*****************************************************
//	 * GENERATE TEST PAPERS (SAMPLE)
//	 ******************************************************/
//	public void generateTestPaper(EntityManager em) {
//
//		// use persistence.xml configuration
//		em.getTransaction().begin();
//
//		List<Topic> topics = FetchTopics(em);
//		for (Topic obj : topics) {
//			//
//			System.out.println(obj);
//		}
//
//		for (int i = 1; i <= 4; i++) {
//			Query query = em.createQuery(
//					"FROM Question where Id>=FLOOR(RAND()*(25-10+1))+10 AND Id<FLOOR(RAND()*(50-10+1))+30 ");
//			List<Question> results = query.getResultList();
//
////			for (Question obj : results) {
////				System.out.println(obj.getQuestion() + "   " + obj.getChoice_1() + "   " + obj.getChoice_2() + "    "
////						+ obj.getChoice_3() + "    " + obj.getChoice_4());
////
////			}
//
//			// int ran = (int) (Math.random() * (3 - 1 + 1) + 1);
//
//			TestPaper test1 = new TestPaper();
//			test1.setQuestionSet(results);
//			test1.setTestName("Full Stack JAVA");
//			test1.setTestLevel("I");
//			test1.setTopics(topics);
//			em.merge(test1);
//
//		}
//
//		em.getTransaction().commit();
//
//	}
//
//	/***************************************
//	 * ATTEMPTED TEST GENERATION (SAMPLE)
//	 ***************************************/
//
//	public void createAttemptedTest(EntityManager em) {
//		em.getTransaction().begin();
//
////	    create the attempted test object  
//		List<TestPaper> test = FetchTestpaper(em);
//		Map<Question, Character> hashmap = new HashMap<Question, Character>();
//		AttemptedTest test2 = new AttemptedTest();
//		List<Score> scores = FetchScores(em);
//		int finalScore = 0;
//		int k = 0;
//		for (TestPaper test1 : test) {
//
//			int no_of_attempt = (int) (Math.random() * (3 - 1 + 1) + 1);
//
//			for (int i = 0; i < no_of_attempt; i++) {
//
//				test2.setTest(test1);
//				finalScore = calculateFinalScore(test1);
//				hashmap = testAnswers(test1);
//				test2.setFinalScore(finalScore);
//				test2.setQuestionAnswersSet(hashmap);
//				test2.setScore(scores.get(k));
//				em.merge(test2);
//				k++;
//			}
//
//		}
//		em.getTransaction().commit();
//	}
//
////	public void setScoreIdAttemptedTest(EntityManager em) {
////		em.getTransaction().begin();
////
////		List<Score> scores = FetchScores(em);
////		List<AttemptedTest> testA = FetchAttemptedTestPaper1(1, 10, em);
////
////		int i = 0;
////		for (AttemptedTest test1 : testA) {
////			test1.setScore(scores.get(i++));
////		}
////
////		em.getTransaction().commit();
////
////	}
//
//	public int calculateFinalScore(TestPaper testPaper) {
//
//		int finalScore = 0;
//		Map<Question, Character> hashmap = new HashMap<Question, Character>();
//		hashmap = testAnswers(testPaper);
//
//		// printing the objects of hashmap
//		Set<Map.Entry<Question, Character>> entries = hashmap.entrySet();
//		for (Map.Entry<Question, Character> hm : entries) {
//			String ans = hm.getKey().getAnswer();
//			char user_ans = hm.getValue();
//			String st = Character.toString(user_ans);
//			// System.out.println(x + " : " + y);
//			if (ans.equals(st)) {
//				finalScore += 1;
//			}
//
//		}
//
//		return finalScore;
//	}
//
//	public Map<Question, Character> testAnswers(TestPaper testPaper) {
//
//		Map<Question, Character> hashmap = new HashMap<Question, Character>();
//
//		char user_ans = ' ';
//		char[] alphabet = { 'A', 'B', 'C', 'D' };
//
//		// user_ans=(int)(Math.random()*(max-min+1)+min);
//		// System.out.println(testPaper.toString());
//
//		List<Question> obj1 = testPaper.getQuestionSet();
//		for (Question q : obj1) {
//			user_ans = alphabet[(int) (Math.random() * 10 % 4)];
//			hashmap.put(q, user_ans);
//			// System.out.println(q.toString());
//		}
//
//		return hashmap;
//
//	}
//
////	private TestPaper getTestPaperObject(EntityManager em, int ID) {
////		// TODO Auto-generated method stub
////		Query query = em.createQuery("FROM TestPaper where testId=" + ID);
////		TestPaper testPaper = (TestPaper) query.getResultList().get(0);
////
////		return testPaper;
////	}
//
//	public List<TestPaper> FetchTestpaper(EntityManager em) {
//
//		Query query = em.createQuery("FROM TestPaper where Id>=1 AND Id<=4");
//		List<TestPaper> testPaper = query.getResultList();
////		for (TestPaper obj : testPaper) {
////			for (Question q : obj.getQuestionSet()) {
////				System.out.println(q.getQuestion() + "        " + q.getChoice_1() + "     " + q.getChoice_2() + "      "
////						+ q.getChoice_3() + "     " + q.getChoice_4());
////			}
////			System.out.println(obj.getTestId() + "   " + obj.getTestName() + "    " + obj.getTestLevel() + "    ");
////
////		}
//
////		em.close();
////		emf.close();
//
//		return testPaper;
//
//	}
//
//	public List<TopicWiseScore> Fetch_TopicWiseScoreList(EntityManager em, int start, int end) {
//
//		Query query = em.createQuery("FROM TopicWiseScore  where Id>=" + start + " AND Id<=" + end);
//		List<TopicWiseScore> TopicWiseScore_list = query.getResultList();
//
//		return TopicWiseScore_list;
//
//	}
//
//	public void createTopicWiseScore(EntityManager em) {
//
//		em.getTransaction().begin();
//		List<Topic> topics = FetchTopics(em);
//		List<Score> scores = FetchScores(em);
//
////		System.out.println("########");
////		System.out.println(topics.size());
////		System.out.println(scores.size());
//
//		TopicWiseScore St = new TopicWiseScore();
//		St.setTopic(topics.get(0));
//		St.setScore(scores.get(0));
//
//		em.merge(St);
//
//		TopicWiseScore St1 = new TopicWiseScore();
//		St1.setTopic(topics.get(1));
//		St1.setScore(scores.get(1));
//
//		em.merge(St1);
//
//		TopicWiseScore St2 = new TopicWiseScore();
//		St2.setTopic(topics.get(2));
//		St2.setScore(scores.get(2));
//
//		em.merge(St2);
//
//		TopicWiseScore St4 = new TopicWiseScore();
//		St4.setTopic(topics.get(0));
//		St4.setScore(scores.get(3));
//
//		em.merge(St4);
//
//		TopicWiseScore St5 = new TopicWiseScore();
//		St5.setTopic(topics.get(1));
//		St5.setScore(scores.get(4));
//
//		em.merge(St5);
//
//		TopicWiseScore St6 = new TopicWiseScore();
//		St6.setTopic(topics.get(2));
//		St6.setScore(scores.get(5));
//
//		em.merge(St6);
//
//		TopicWiseScore St7 = new TopicWiseScore();
//		St7.setTopic(topics.get(2));
//		St7.setScore(scores.get(6));
//
//		em.merge(St7);
//
//		TopicWiseScore St8 = new TopicWiseScore();
//		St8.setTopic(topics.get(1));
//		St8.setScore(scores.get(7));
//
//		em.merge(St5);
//
//		TopicWiseScore St9 = new TopicWiseScore();
//		St9.setTopic(topics.get(0));
//		St9.setScore(scores.get(8));
//
//		em.merge(St9);
//		em.getTransaction().commit();
//
//	}
//
//	// create user and update the friendship mapping
//	public void createUser(EntityManager em) {
//		em.getTransaction().begin();
//
//		User user1 = new User();
//		User user2 = new User();
//		User user3 = new User();
////		User user4 = new User();
////		User user5 = new User();
////		User user6 = new User();
////		User user7 = new User();
////		User user8 = new User();
//
//		List<TestPaper> TestPaperList = FetchTestpaper(em);
//
//		List<AttemptedTest> attemptTestPaperList = FetchAttemptedTestPaper1(1, 2, em);
//
//		List<TopicWiseScore> TopicWiseScoreList = Fetch_TopicWiseScoreList(em, 1, 3);
//		// System.out.println("jabjka : " + TopicWiseScoreList);
//
//		// List<User> friends = new ArrayList<User>();
//
//		user1.setUserName("Sharif");
//		user1.setPassword("password1");
//		user1.setTestPaperList(TestPaperList);
//		user1.setAttemptTestPaperList(attemptTestPaperList);
//		user1.setTopicWiseScoreList(TopicWiseScoreList);
//
//		// user1.setFriends(friends);
//
//		em.merge(user1);
//
//		attemptTestPaperList = FetchAttemptedTestPaper1(3, 4, em);
//		TopicWiseScoreList = Fetch_TopicWiseScoreList(em, 4, 6);
//		// System.out.println("jabjk1 : " + TopicWiseScoreList);
//		user2.setUserName("Ramesh");
//		user2.setPassword("password2");
//		user2.setTestPaperList(TestPaperList);
//		user2.setAttemptTestPaperList(attemptTestPaperList);
//		user2.setTopicWiseScoreList(TopicWiseScoreList);
////		 user2.setFriends(friends);
//
//		em.merge(user2);
//
//		attemptTestPaperList = FetchAttemptedTestPaper1(5, 6, em);
//		TopicWiseScoreList = Fetch_TopicWiseScoreList(em, 7, 9);
//		user3.setUserName("Nilesh");
//		user3.setPassword("password3");
//		user3.setTestPaperList(TestPaperList);
//		user3.setAttemptTestPaperList(attemptTestPaperList);
//		user3.setTopicWiseScoreList(TopicWiseScoreList);
//////		user3.setFriends(friends);
////
//		em.merge(user3);
//
////		atemptTestSet = FetchAttemptedTestPaper1(7, 8, em);
////		scoreTopic = Fetch_scoreTopic(em);
////		user4.setUserName("Somesh");
////		user4.setPassword("password4");
////		user4.setUnattemptTestSet(unattemptTestSet);
////		user4.setAtemptTestSet(atemptTestSet);
////		user4.setScoreTopic(scoreTopic);
////////	    user4.setFriends(friends);
//////
////		em.merge(user4);
////
////		atemptTestSet = FetchAttemptedTestPaper1(9, 10, em);
////		scoreTopic = Fetch_scoreTopic(em);
////		user5.setUserName("Farukh");
////		user5.setPassword("password5");
////		user5.setUnattemptTestSet(unattemptTestSet);
////		user5.setAtemptTestSet(atemptTestSet);
////		user5.setScoreTopic(scoreTopic);
////
////		em.merge(user5);
////
////		atemptTestSet = FetchAttemptedTestPaper1(11, 12, em);
////		scoreTopic = Fetch_scoreTopic(em);
////		user6.setUserName("Sarukh");
////		user6.setPassword("password6");
////		user6.setUnattemptTestSet(unattemptTestSet);
////		user6.setAtemptTestSet(atemptTestSet);
////		user6.setScoreTopic(scoreTopic);
////
////		em.merge(user6);
////
////		atemptTestSet = FetchAttemptedTestPaper1(13, 14, em);
////		scoreTopic = Fetch_scoreTopic(em);
////		user7.setUserName("Amir");
////		user7.setPassword("password7");
////		user7.setUnattemptTestSet(unattemptTestSet);
////		user7.setAtemptTestSet(atemptTestSet);
////		user7.setScoreTopic(scoreTopic);
////
////		em.merge(user7);
////
////		atemptTestSet = FetchAttemptedTestPaper1(15, 16, em);
////		scoreTopic = Fetch_scoreTopic(em);
////		user8.setUserName("Alam");
////		user8.setPassword("password8");
////		user8.setUnattemptTestSet(unattemptTestSet);
////		user8.setAtemptTestSet(atemptTestSet);
////		user8.setScoreTopic(scoreTopic);
////
////		em.merge(user8);
//
//		em.getTransaction().commit();
//
//		update_userToDb(em);
//	}
//
//	public void update_userToDb(EntityManager em) {
//
//		em.getTransaction().begin();
//
//		List<User> friends = new ArrayList<User>();
//
//		List<User> User_obj = new ArrayList<User>();
//		User_obj = FetchUser(em);
//
//		for (User u : User_obj) {
//			friends = Fetch_friendList(em);
//			u.setFriends(friends);
//			em.merge(u);
//		}
//
//		em.getTransaction().commit();
//
//	}
//
//	public List<User> FetchUser(EntityManager em) {
//
//		Query query = em.createQuery("FROM User ");
//		List<User> users = query.getResultList();
//
////		for (User obj : users) {
////			System.out.println(obj.getUserName() + " " + obj.getPassword());
////
////		}
//
//		return users;
//	}
//
//	public List<User> Fetch_friendList(EntityManager em) {
//
//		Query query = em.createQuery("FROM User ");
//		List<User> users = query.getResultList();
//
//		Collections.shuffle(users);
//
//		// System.out.println(users.size());
//
//		int length = (int) (Math.random() * (3 - 1 + 1) + 1);
//		// System.out.println(length);
//		List<User> randomUsers = users.subList(0, length);
//
////		for (User obj : randomUsers) {
////
////			System.out.println(obj.getUserName() + " " + obj.getPassword());
////		}
//		return randomUsers;
//	}
//
//	public List<AttemptedTest> FetchAttemptedTestPaper1(int start, int end, EntityManager em) {
//
//		// em.getTransaction().begin();
//
//		Query query = em.createQuery("FROM AttemptedTest where Id>=" + start + " AND Id <=" + end);
//		List<AttemptedTest> testPaper = query.getResultList();
//
//		return testPaper;
//	}
//
//	public List<Topic> FetchTopics(EntityManager em) {
//
////		em.getTransaction().begin();
//
//		Query query = em.createQuery("FROM Topic where Id>=1 AND Id <=3");
//		List<Topic> topics = query.getResultList();
//
////		for (Topic obj : topics) {
////			//
////			System.out.println(obj);
////		}
//
//		return topics;
//	}
//
//	public List<Score> FetchScores(EntityManager em) {
//
//		// em.getTransaction().begin();
//
//		Query query = em.createQuery("FROM Score where Id>=1 AND Id <=9");
//		List<Score> scores = query.getResultList();
//
//		return scores;
//	}
//
//}
//
//class myEntityManager {
//	EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Online_Exam");
//	EntityManager em = emf.createEntityManager();
//
//	public EntityManager getentitymanager() {
//		return em;
//	}
//
//	public void closeAll() {
//		em.close();
//		emf.close();
//
//	}
//
//}
