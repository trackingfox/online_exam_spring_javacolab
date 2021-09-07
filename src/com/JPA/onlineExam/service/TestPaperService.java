package com.JPA.onlineExam.service;

import java.util.ArrayList;
import java.util.List;
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
	private TestPaperRepository repository;

	@Autowired
	private QuestionRepository repository2;

	@Autowired
	private TopicRepository repository3;

	public TestPaperRepository getRepository() {
		return repository;
	}

	public void setRepository(TestPaperRepository repository) {
		this.repository = repository;
	}

	public List<TestPaper> generateTestPaper() {

		List<TestPaper> testPaperList = new ArrayList<>();

		List<Topic> topics = repository3.FetchTopics();

		for (int i = 1; i <= 8; i++) {

			Set<Question> results = repository2.fetchQuestions();
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

		testPaperList.forEach(x -> repository.save(x));

	}

}
