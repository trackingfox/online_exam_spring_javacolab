package com.JPA.onlineExam.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JPA.onlineExam.model.Question;
import com.JPA.onlineExam.model.TestPaper;
import com.JPA.onlineExam.model.Topic;
import com.JPA.onlineExam.repository.TestPaperRepository;

@Service
@Transactional
public class TestPaperService_TOW {

	@Autowired
	private TestPaperRepository repository;

	public TestPaperRepository getRepository() {
		return repository;
	}

	public void setRepository(TestPaperRepository repository) {
		this.repository = repository;
	}

	public List<TestPaper> generateTestPaper() {

		List<TestPaper> testPaperList = new ArrayList<>();

//		System.out.println(topics);

		for (int i = 1; i <= 3; i++) {

			List<Question> results = repository.fetchQuestions();
			System.out.println(results);
			TestPaper test1 = new TestPaper();
			test1.setQuestionSet(new HashSet<>(results));
			test1.setTestName("Full Stack JAVA");
			test1.setTestLevel("I");
			List<Topic> topics = repository.FetchTopics();
			test1.setTopics(new HashSet<>(topics));
			testPaperList.add(test1);
		}
		return testPaperList;

	}

	public void populateTestPaper() {
		List<TestPaper> testPaperList = generateTestPaper();

		testPaperList.forEach(x -> repository.save(x));

	}

	public List<TestPaper> getallTests() {
		return repository.findAll();
	}
}
