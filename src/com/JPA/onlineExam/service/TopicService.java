package com.JPA.onlineExam.service;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JPA.onlineExam.model.Topic;
import com.JPA.onlineExam.repository.TopicRepository;

@Service
public class TopicService {

	@Autowired
	private TopicRepository repository;

	public TopicRepository getRepository() {
		return repository;
	}

	public void setRepository(TopicRepository repository) {
		this.repository = repository;
	}

	public List<Topic> generateTopics() {

		List<Topic> topicList = new ArrayList<>();
		Topic topic1 = new Topic();
		Topic topic2 = new Topic();
		Topic topic3 = new Topic();
		Topic topic4 = new Topic();
		Topic topic5 = new Topic();
		Topic topic6 = new Topic();
		Topic topic7 = new Topic();
		Topic topic8 = new Topic();

		topic1.setContent("Hello JAVA");
		topic1.setTitle("JAVA");
		topicList.add(topic1);

		topic2.setContent("Hi Angular");
		topic2.setTitle("ANGULAR");
		topicList.add(topic2);

		topic3.setContent("hello Python");
		topic3.setTitle("PYTHON");
		topicList.add(topic3);

		topic4.setContent("hello Sun");
		topic4.setTitle("SUN");
		topicList.add(topic4);

		topic5.setContent("hello Moon");
		topic5.setTitle("Moon");
		topicList.add(topic5);

		topic6.setContent("hello XMan");
		topic6.setTitle("XMAN");
		topicList.add(topic6);

		topic7.setContent("hello HEMan");
		topic7.setTitle("HeMAN");
		topicList.add(topic7);

		topic8.setContent("hello YYMan");
		topic8.setTitle("YYMAN");
		topicList.add(topic8);

		return topicList;

	}

	public void populateTopics() throws IllegalStateException, FileNotFoundException {
		List<Topic> topicList = generateTopics();

		topicList.forEach(x -> repository.save(x));
	}

	public List<Topic> fetchTopics() {

		List<Topic> topics = repository.FetchTopics();
		return topics;

	}

}
