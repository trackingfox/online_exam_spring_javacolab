package com.JPA.onlineExam.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JPA.onlineExam.model.AttemptedTest;
import com.JPA.onlineExam.model.Question;
import com.JPA.onlineExam.model.Score;
import com.JPA.onlineExam.model.TestPaper;
import com.JPA.onlineExam.repository.AttemptedTestRepository;
import com.JPA.onlineExam.repository.QuestionRepository;
import com.JPA.onlineExam.repository.ScoreRepository;
import com.JPA.onlineExam.repository.TestPaperRepository;

@Service
public class AttemptedTestService {

	@Autowired
	private AttemptedTestRepository AttRepository;

	@Autowired
	private QuestionRepository QRepository;

	@Autowired
	private TestPaperRepository testPaperRepository;

	@Autowired
	private ScoreRepository repository3;

	public AttemptedTestRepository getRepository() {
		return AttRepository;
	}

	public void setRepository(AttemptedTestRepository repository) {
		this.AttRepository = repository;
	}

	public void createOneAttemptedTest(TestPaper testpaper) {
		AttemptedTest test2 = new AttemptedTest();
		Map<Question, Character> hashmap = new HashMap<Question, Character>();

		testpaper.getQuestionSet().forEach(y -> {
			hashmap.put(y, null);

		});

		test2.setTest(testpaper);
		test2.setQuestionAnswersSet(hashmap);

		AttRepository.save(test2);

	}

	// UPDATE TEST QUESTIONS WITH USER ANSWERS
	public void update_TestQuestion_With_UserAnswers_method2(long att_testId, long Qid, char user_answer) {

		Optional<AttemptedTest> AT = AttRepository.findById(att_testId);
		AttemptedTest Attempted_testpaper = AT.get();

		TestPaper testpaper = Attempted_testpaper.getTest();
		Map<Question, Character> hashmap = Attempted_testpaper.getQuestionAnswersSet();

		// System.out.println("/" + user_answer + "/" + Qid + "/" + testpaper.getId());
		testpaper.getQuestionSet().forEach(y -> {
			// System.out.print(y.getId() + " ," /* y.getQuestion() */);
			if (y.getId() == Qid) {

				hashmap.put(y, user_answer);

				// System.out.println(y);

			}

		});
		Attempted_testpaper.setQuestionAnswersSet(hashmap);
		// System.out.println(Attempted_testpaper.getQuestionAnswersSet());
		AttRepository.save(Attempted_testpaper);
	}

	// UPDATE TEST QUESTIONS WITH USER ANSWERS
	public void update_TestQuestion_With_UserAnswers_method1(long att_testId, long Qid, char user_answer) {

		Optional<AttemptedTest> AT = AttRepository.findById(att_testId);
		AttemptedTest Attempted_testpaper = AT.get();

		// TestPaper testpaper = Attempted_testpaper.getTest();
		Map<Question, Character> hashmap = Attempted_testpaper.getQuestionAnswersSet();

		Set<Map.Entry<Question, Character>> entries = hashmap.entrySet();
		for (Map.Entry<Question, Character> hm : entries) {

			if (hm.getKey().getId() == Qid) {

				hashmap.put(hm.getKey(), user_answer);

				// System.out.println(y.toString());

			}

		}

		Attempted_testpaper.setQuestionAnswersSet(hashmap);
		// System.out.println(Attempted_testpaper.getQuestionAnswersSet());
		AttRepository.save(Attempted_testpaper);
	}

	// SCORE CALCULATION FOR EACH ATTEMPTED TEST
	public void ScoreCalculation(long AttemptedTest_Id) {

		Map<Question, Character> hashmap = new HashMap<Question, Character>();
		Optional<AttemptedTest> AT = AttRepository.findById(AttemptedTest_Id);
		AttemptedTest Attempted_testpaper = AT.get();
		hashmap = Attempted_testpaper.getQuestionAnswersSet();

		int finalScore = 0;
		Set<Map.Entry<Question, Character>> entries = hashmap.entrySet();
		for (Map.Entry<Question, Character> hm : entries) {
			String ans = hm.getKey().getAnswer();
			char user_ans = hm.getValue();
			String st = Character.toString(user_ans);
			// System.out.println(st + " : " + ans + "/");
			if (ans.equals(st)) {
				finalScore += 1;
			}

		}
		// System.out.println("/" + finalScore);
		Attempted_testpaper.setFinalScore(finalScore);
		AttRepository.save(Attempted_testpaper);

	}

	public void finishTest(long AttemptedTest_Id) {

		Optional<AttemptedTest> AT = AttRepository.findById(AttemptedTest_Id);
		AttemptedTest Attempted_testpaper = AT.get();

		Attempted_testpaper.setFinished(true);
		AttRepository.save(Attempted_testpaper);

	}

	/*--------------------------------------------------------------------------------------------
	-----------------------------------------------------------------------------------------------*/

	/*
	 * For testing purpose we are creating list of attempted test. Practically only
	 * one attempted test will be created at a time and also we have to pass the
	 * testpaper id for creating respective attempted test.
	 */
	public List<AttemptedTest> createlistOfAttemptedTest() {

//	    create the attempted test object  
		Set<TestPaper> testPapers = testPaperRepository.fetchTestPapers();
		Map<Question, Character> hashmap = new HashMap<Question, Character>();
		List<AttemptedTest> AttemptedTestPaperList = new ArrayList<>();

		List<Score> scores = repository3.FetchScores();

		int finalScore = 0;
		int scoreListid = 0;
		for (TestPaper test : testPapers) {
			scoreListid = 0;
			int no_of_attemptedTest = (int) (Math.random() * (9 - 1 + 1) + 1);

			for (int i = 0; i < no_of_attemptedTest; i++) {

				AttemptedTest Atest = new AttemptedTest();
				finalScore = calculateFinalScore(test);
				hashmap = testAnswers(test);

				Atest.setTest(test);
				Atest.setFinalScore(finalScore);
				Atest.setQuestionAnswersSet(hashmap);
				Atest.setScore(scores.get(scoreListid));
				AttemptedTestPaperList.add(Atest);
				scoreListid++;

				// System.out.println(test2.toString());

			}

		}
		return AttemptedTestPaperList;
	}

	public void populateAttemptedTestPaper() {
		List<AttemptedTest> Att_testPaperList = createlistOfAttemptedTest();
		Att_testPaperList.forEach(x -> AttRepository.save(x));

//		AttemptedTest test2 = createOneAttemptedTest(TestPaper testpaper);
//		repository.save(test2);

	}

//CALCULATING FINAL SCORE FOR EACH TESTPAPER(TESTING)
	public int calculateFinalScore(TestPaper testPaper) {

		int finalScore = 0;
		Map<Question, Character> hashmap = new HashMap<Question, Character>();
		hashmap = testAnswers(testPaper);

		// printing the objects of hashmap
		Set<Map.Entry<Question, Character>> entries = hashmap.entrySet();
		for (Map.Entry<Question, Character> hm : entries) {
			String ans = hm.getKey().getAnswer();
			char user_ans = hm.getValue();
			String st = Character.toString(user_ans);
			// System.out.println(x + " : " + y);
			if (ans.equals(st)) {
				finalScore += 1;
			}

		}

		return finalScore;
	}

//MAPPING QUESTION OF EACH TESTPAPER WITH ACTUAL ANSWER(TESTING)
	public Map<Question, Character> testAnswers(TestPaper testPaper) {

		Map<Question, Character> hashmap = new HashMap<Question, Character>();

		char user_ans = ' ';
		char[] alphabet = { 'A', 'B', 'C', 'D' };

		// user_ans=(int)(Math.random()*(max-min+1)+min);
		// System.out.println(testPaper.toString());

		Set<Question> obj1 = testPaper.getQuestionSet();
		for (Question q : obj1) {
			user_ans = alphabet[(int) (Math.random() * 10 % 4)];
			hashmap.put(q, user_ans);
			// System.out.println(q.toString());
		}

		return hashmap;

	}

}
