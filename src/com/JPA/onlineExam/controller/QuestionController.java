package com.JPA.onlineExam.controller;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JPA.onlineExam.model.Question;
import com.JPA.onlineExam.repository.QuestionRepository;
import com.JPA.onlineExam.service.QuestionService;

@RestController
@RequestMapping(value = "/questions", produces = { MediaType.APPLICATION_JSON_VALUE })
public class QuestionController {

	@Autowired
	private QuestionRepository repository;

	@Autowired
	private QuestionService populateQuestion;

	public QuestionService getPopulateQuestion() {
		return populateQuestion;
	}

	public void setPopulateQuestion(QuestionService populateQuestion) {
		this.populateQuestion = populateQuestion;
	}

	public QuestionRepository getRepository() {
		return repository;
	}

	public void setRepository(QuestionRepository repository) {
		this.repository = repository;
	}

	@GetMapping(value = "/allquestions")
	public List<Question> getAllCustomers() {

		return repository.findAll();
	}

	@GetMapping(value = "/ping")
	public String ping() {

		return "hello world hello cbb";
	}

	@GetMapping(value = "/populate")
	public String populateQues() throws IllegalStateException, FileNotFoundException {

		// populateService.importCustomerFromCsv();
		populateQuestion.populateQuestion();

		return "populate done ok hello";
	}

	@GetMapping(value = "/fetchQuestion")
	public String fetchQues() {

		// fetch questions from repository
		Set<Question> ques = repository.fetchQuestions();
		// System.out.println(ques.toString());

		return ques.toString();
	}

}
