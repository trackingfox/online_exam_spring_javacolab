package com.JPA.onlineExam.controller;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JPA.onlineExam.model.Topic;
import com.JPA.onlineExam.repository.TopicRepository;
import com.JPA.onlineExam.service.TopicService;

@RestController
@RequestMapping(value = "/topics", produces = { MediaType.APPLICATION_JSON_VALUE })
public class TopicController {

	@Autowired
	private TopicRepository repository;

	@Autowired
	private TopicService populateTopics;

	public TopicRepository getRepository() {
		return repository;
	}

	public void setRepository(TopicRepository repository) {
		this.repository = repository;
	}

	public TopicService getPopulateTopics() {
		return populateTopics;
	}

	public void setPopulateTopics(TopicService populateTopics) {
		this.populateTopics = populateTopics;
	}

	@GetMapping(value = "/alltopics")
	public List<Topic> getAllTopics() {

		return repository.findAll();
	}

	@GetMapping(value = "/ping")
	public String ping() {

		return "hello world hello cbb";
	}

	@GetMapping(value = "/populateTopics")
	public String populateTop() throws IllegalStateException, FileNotFoundException {

		// populateService.importCustomerFromCsv();
		populateTopics.populateTopics();

		return "populate done ok hello";
	}

	@GetMapping(value = "/fetchTopic")
	public String fetchTop() {

		// fetch questions from repository
		Set<Topic> topics = repository.FetchTopics();
		// System.out.println(ques.toString());

		return topics.toString();
	}

}
