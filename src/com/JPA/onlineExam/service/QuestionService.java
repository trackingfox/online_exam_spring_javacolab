package com.JPA.onlineExam.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JPA.onlineExam.model.Question;
import com.JPA.onlineExam.model.QuestionTemp;
import com.JPA.onlineExam.model.Topic;
import com.JPA.onlineExam.repository.QuestionRepository;
import com.JPA.onlineExam.repository.TopicRepository;
import com.opencsv.bean.CsvToBeanBuilder;

@Service
public class QuestionService {
	@Autowired
	private TopicRepository topicRepository;;

	@Autowired
	private QuestionRepository repository;

	public QuestionRepository getRepository() {
		return repository;
	}

	public void setRepository(QuestionRepository repository) {
		this.repository = repository;
	}

	public List<Question> importQuestionFromCsv() throws IllegalStateException, FileNotFoundException {

		String filename = "data/MCQDBSample1.csv";

		ClassLoader classloader = getClass().getClassLoader();
		String filePath = classloader.getResource(filename).getPath();
		// System.out.println(filePath);

		List<Question> QuestionList = new CsvToBeanBuilder(new FileReader(filePath)).withType(Question.class).build()
				.parse();
		return QuestionList;
	}

	public void populateQuestion() throws IllegalStateException, FileNotFoundException {
		List<Question> questionList = importQuestionFromCsv();
		System.out.println(questionList.toString());
		questionList.forEach(x -> repository.save(x));
	}

	public List<QuestionTemp> importQuestionTempFromCsv() throws IllegalStateException, FileNotFoundException {

		String filename = "data/MCQDBSample2.csv";

		ClassLoader classloader = getClass().getClassLoader();
		String filePath = classloader.getResource(filename).getPath();
		// System.out.println(filePath);

		List<QuestionTemp> QuestionList = new CsvToBeanBuilder(new FileReader(filePath)).withType(QuestionTemp.class)
				.build().parse();
		// System.out.println(QuestionList);
		return QuestionList;
	}

	@Test
	public void callQuestion() throws IllegalStateException, FileNotFoundException {
		// importQuestionTempFromCsv();
		// populateQuestion();
		populateQuestionWithTopics();
	}

	@Transactional
	public void populateQuestionWithTopics() throws IllegalStateException, FileNotFoundException {

		List<QuestionTemp> questionTempList = importQuestionTempFromCsv();
		List<Question> questionList = new ArrayList<>();
		// System.out.println(questionList.toString());

		for (QuestionTemp Q : questionTempList) {

			Question Q1 = new Question();

			// For Primary Topic
			List<Topic> databaseTopic = topicRepository.findByTitle(Q.getPrimaryTopic());
			// List<Topic> databaseTopic = topicRepository.findAll();
			// System.out.println("from database " + databaseTopic);

			if (databaseTopic.isEmpty()) {

				Topic T1 = new Topic();
				T1.setTitle(Q.getPrimaryTopic());
				T1.setContent("hello Topic");
				Q1.setPrimaryTopic(T1);

			} else {
				Q1.setPrimaryTopic(databaseTopic.get(0));
			}

			// For secondary Topic
			List<Topic> sT = new ArrayList<>();
			String str = Q.getSecondaryTopics();

			String[] TopicsStr = str.split(",");

			// System.out.println(TopicsStr);
			// Setting the secondary topics after splitting the string
			for (String s : TopicsStr) {
				List<Topic> databaseTopic2 = topicRepository.findByTitle(s);
				if (databaseTopic2.isEmpty()) {

					Topic T1 = new Topic();
					T1.setTitle(s);
					T1.setContent("hello Topic");
					sT.add(T1);

				} else {

					sT.add(databaseTopic2.get(0));
				}

			}
			Q1.setSecond_Topics(sT);

			Q1.setQuestion(Q.getQuestion());
			Q1.setChoice_1(Q.getChoice_1());
			Q1.setChoice_2(Q.getChoice_2());
			Q1.setChoice_3(Q.getChoice_3());
			Q1.setChoice_4(Q.getChoice_4());
			Q1.setAnswer(Q.getAnswer());
			Q1.setLevel(Integer.parseInt(Q.getLevel()));

			questionList.add(Q1);
			repository.save(Q1);
		}
		// System.out.println(questionList);
		// questionList.forEach(x -> repository.save(x));

	}

	public Set<Question> fetchQues() {
		Set<Question> results = repository.fetchQuestions();
		return results;
	}

}
