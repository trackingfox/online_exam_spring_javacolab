package com.JPA.onlineExam.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JPA.onlineExam.model.Question;
import com.JPA.onlineExam.model.QuestionTemp;
import com.JPA.onlineExam.repository.QuestionRepository;
import com.opencsv.bean.CsvToBeanBuilder;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepository repository;

	public QuestionRepository getRepository() {
		return repository;
	}

	public void setRepository(QuestionRepository repository) {
		this.repository = repository;
	}

	public void populateQuestion() throws IllegalStateException, FileNotFoundException {
		List<QuestionTemp> questionList = importQuestionTempFromCsv();
		// System.out.println(questionList.toString());

		questionList.forEach(x -> repository.save(x));
	}

//	public List<Question> importQuestionFromCsv() throws IllegalStateException, FileNotFoundException {
//
//		String filename = "data/MCQDBSample2.csv";
//
//		ClassLoader classloader = getClass().getClassLoader();
//		String filePath = classloader.getResource(filename).getPath();
//		// System.out.println(filePath);
//
//		List<Question> QuestionList = new CsvToBeanBuilder(new FileReader(filePath)).withType(Question.class).build()
//				.parse();
//		return QuestionList;
//	}

//	public void populateQuestionTemp() throws IllegalStateException, FileNotFoundException {
//		List<Question> questionList = importQuestionFromCsv();
//		System.out.println(questionList.toString());
//		questionList.forEach(x -> repository.save(x));
//	}
//	
//	

	public List<QuestionTemp> importQuestionTempFromCsv() throws IllegalStateException, FileNotFoundException {

		String filename = "data/MCQDBSample2.csv";

		ClassLoader classloader = getClass().getClassLoader();
		String filePath = classloader.getResource(filename).getPath();
		// System.out.println(filePath);

		List<QuestionTemp> QuestionList = new CsvToBeanBuilder(new FileReader(filePath)).withType(QuestionTemp.class)
				.build().parse();
		return QuestionList;
	}

	public Set<Question> fetchQues() {
		Set<Question> results = repository.fetchQuestions();
		return results;
	}

	// only for testing using entityManager below
	@Test
	public void importTodb() throws IllegalStateException, FileNotFoundException {

		// use persistence.xml configuration

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Online_Exam");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		List<Question> questionlist1 = this.importQuestionFromCsv();
		questionlist1.forEach(x -> em.merge(x));
		em.getTransaction().commit();
		em.close();
		emf.close();

	}

}
