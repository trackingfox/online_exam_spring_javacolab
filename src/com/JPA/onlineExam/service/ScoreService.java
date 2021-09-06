package com.JPA.onlineExam.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JPA.onlineExam.model.Score;
import com.JPA.onlineExam.repository.ScoreRepository;

@Service
public class ScoreService {

	@Autowired
	private ScoreRepository repository;

	public ScoreRepository getRepository() {
		return repository;
	}

	public void setRepository(ScoreRepository repository) {
		this.repository = repository;
	}

	public List<Score> generateScores() {

		List<Score> ScoreList = new ArrayList<>();

		Score score1 = new Score();
		Score score2 = new Score();
		Score score3 = new Score();
		Score score4 = new Score();
		Score score5 = new Score();
		Score score6 = new Score();
		Score score7 = new Score();
		Score score8 = new Score();
		Score score9 = new Score();

		score1.setScore(56);
		score1.setPercentile(78);
		ScoreList.add(score1);

		score2.setScore(87);
		score2.setPercentile(99);
		ScoreList.add(score2);

		score3.setScore(72);
		score3.setPercentile(90);
		ScoreList.add(score3);

		score4.setScore(75);
		score4.setPercentile(93);
		ScoreList.add(score4);

		score5.setScore(76);
		score5.setPercentile(94);
		ScoreList.add(score5);

		score6.setScore(67);
		score6.setPercentile(82);
		ScoreList.add(score6);

		score7.setScore(60);
		score7.setPercentile(80);
		ScoreList.add(score7);

		score8.setScore(59);
		score8.setPercentile(70);
		ScoreList.add(score8);

		score9.setScore(59);
		score9.setPercentile(70);
		ScoreList.add(score9);

		return ScoreList;

	}

	public void populateScore() {
		List<Score> ScoreList = generateScores();

		ScoreList.forEach(x -> repository.save(x));

	}

}
