package com.JPA.onlineExam.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TopicWiseScore")
public class TopicWiseScore {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;

	@OneToOne
	private Topic topic;

	@OneToOne
	private Score score;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "TopicWiseScore [Id=" + Id + ", topic=" + topic + ", score=" + score + "]";
	}

}
