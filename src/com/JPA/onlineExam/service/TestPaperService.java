package com.JPA.onlineExam.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JPA.onlineExam.model.Question;
import com.JPA.onlineExam.model.TestPaper;
import com.JPA.onlineExam.model.Topic;
import com.JPA.onlineExam.repository.QuestionRepository;
import com.JPA.onlineExam.repository.TestPaperRepository;
import com.JPA.onlineExam.repository.TopicRepository;

@Service
public class TestPaperService {

	@Autowired
	private TestPaperRepository TestPaperRepository;

	@Autowired
	private QuestionRepository QRepository;

	@Autowired
	private TopicRepository TopicRepository;

	public TestPaperRepository getRepository() {
		return TestPaperRepository;
	}

	public void setRepository(TestPaperRepository repository) {
		this.TestPaperRepository = repository;
	}

	// GENERATE CUSTOMIZE TESTPAPER
	public void generateCustomizeTestPaper(Integer testPaperType, List<Long> TopicIds, Integer testPaperLevel) {

		Set<Question> results = QRepository.fetchQuestions();
		List<Topic> topics = new ArrayList<>();

		for (Long Id : TopicIds) {
			Optional<Topic> t = TopicRepository.findById(Id);
			Topic topic = t.get();
			topics.add(topic);
		}

		// CALCULATING TESTPAPER LEVEL BY TAKING AVERAGE OF ALL QUESTION LEVEL IN THAT
		// TESTPAPER
		int addlevel = 0;
		float Average = (float) 0.0;
		for (Question Q : results) {
			addlevel = addlevel + Q.getLevel();
		}
		Average = ((float) addlevel / (float) results.size());
		// System.out.println(Average + " " + addlevel + " " + results.size());
		double fractional_part = Average % 1;
		int AverageLevel = (int) ((fractional_part < 0.5) ? Average - fractional_part : Average - fractional_part + 1);

		TestPaper testpaper = new TestPaper();
		testpaper.setTestName("JAVA BASICS");
		testpaper.setQuestionSet(results);
		testpaper.setTestLevel(AverageLevel);
		testpaper.setTopics(topics);
		testpaper.setTestPaperType(testPaperType);

		TestPaperRepository.save(testpaper);
	}

//GENERATE TOPIC WISE TESTPAPER
	public void generateTopicWiseTestPaper(Integer testPaperType, long TopicId, Integer testPaperLevel) {

		Set<Question> results = QRepository.fetchQuestions();
		List<Topic> topics = new ArrayList<>();
		Optional<Topic> t = TopicRepository.findById(TopicId);
		Topic topic = t.get();
		topics.add(topic);
		// CALCULATING TESTPAPER LEVEL BY TAKING AVERAGE OF ALL QUESTION LEVEL IN THAT
		// TESTPAPER
		int addlevel = 0;
		float Average = (float) 0.0;
		for (Question Q : results) {
			addlevel = addlevel + Q.getLevel();
		}
		Average = ((float) addlevel / (float) results.size());
		// System.out.println(Average + " " + addlevel + " " + results.size());
		double fractional_part = Average % 1;
		int AverageLevel = (int) ((fractional_part < 0.5) ? Average - fractional_part : Average - fractional_part + 1);

		TestPaper testpaper = new TestPaper();
		testpaper.setTestName("JAVA BASICS");
		testpaper.setQuestionSet(results);
		testpaper.setTestLevel(AverageLevel);
		testpaper.setTopics(topics);
		testpaper.setTestPaperType(testPaperType);

		TestPaperRepository.save(testpaper);
	}

//GENERATE GLOBAL TESTPAPER
	public void generateGlobalTestPaper(Integer testPaperType, Integer testPaperLevel) {

		Set<Question> results = QRepository.fetchQuestions();
		List<Topic> topics = TopicRepository.FetchTopics();

		// CALCULATING TESTPAPER LEVEL BY TAKING AVERAGE OF ALL QUESTION LEVEL IN THAT
		// TESTPAPER
		int addlevel = 0;
		float Average = (float) 0.0;
		for (Question Q : results) {
			addlevel = addlevel + Q.getLevel();
		}
		Average = ((float) addlevel / (float) results.size());
		// System.out.println(Average + " " + addlevel + " " + results.size());
		double fractional_part = Average % 1;
		int AverageLevel = (int) ((fractional_part < 0.5) ? Average - fractional_part : Average - fractional_part + 1);

		TestPaper testpaper = new TestPaper();
		testpaper.setTestName("JAVA BASICS");
		testpaper.setQuestionSet(results);
		testpaper.setTestLevel(AverageLevel);
		testpaper.setTopics(topics);
		testpaper.setTestPaperType(testPaperType);

		TestPaperRepository.save(testpaper);
	}

//GENERATE MISCELLANEOUS TEST	
	public void generateMiscellaneousTestPaper(Integer testPaperType, Integer testPaperLevel) {

		generateGlobalTestPaper((Integer) 4, (Integer) 3);
	}

//--------------------------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------------------------------

	public List<TestPaper> generateTestPaper() {

		List<TestPaper> testPaperList = new ArrayList<>();

		List<Topic> topics = TopicRepository.FetchTopics();

		for (int i = 1; i <= 8; i++) {

			Set<Question> results = QRepository.fetchQuestions();
			// System.out.println(results.size());
			// System.out.println(results.toString());
			TestPaper test1 = new TestPaper();
			test1.setQuestionSet(results);
			test1.setTestName("Full Stack JAVA");
			test1.setTestLevel(1);
			test1.setTopics(topics);
			testPaperList.add(test1);
		}
		return testPaperList;

	}

	public void populateTestPaper() {
		List<TestPaper> testPaperList = generateTestPaper();
		testPaperList.forEach(x -> TestPaperRepository.save(x));
	}
}
