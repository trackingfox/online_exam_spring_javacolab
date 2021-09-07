package com.JPA.onlineExam.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//@Embeddable
@Entity
@Table(name = "Question")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long Id;
	@Column(length = 3000)
	private String Question;
	@Column(length = 1000)
	private String choice_1;
	@Column(length = 1000)
	private String choice_2;
	@Column(length = 1000)
	private String choice_3;
	@Column(length = 1000)
	private String choice_4;
	@Column(length = 1000)
	private String answer;
	@Column(length = 1000)
	private String level; // 1-for easy, 2-moderate, 3- difficult

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Topic> second_Topics;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Topic primaryTopic;
	// private String tag;

	public Question() {

	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getQuestion() {
		return Question;
	}

	public void setQuestion(String question) {
		Question = question;
	}

	public String getChoice_1() {
		return choice_1;
	}

	public void setChoice_1(String choice_1) {
		this.choice_1 = choice_1;
	}

	public String getChoice_2() {
		return choice_2;
	}

	public void setChoice_2(String choice_2) {
		this.choice_2 = choice_2;
	}

	public String getChoice_3() {
		return choice_3;
	}

	public void setChoice_3(String choice_3) {
		this.choice_3 = choice_3;
	}

	public String getChoice_4() {
		return choice_4;
	}

	public void setChoice_4(String choice_4) {
		this.choice_4 = choice_4;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public List<Topic> getSecond_Topics() {
		return second_Topics;
	}

	public void setSecond_Topics(List<Topic> second_Topics) {
		this.second_Topics = second_Topics;
	}

	public Topic getPrimaryTopic() {
		return primaryTopic;
	}

	public void setPrimaryTopic(Topic primaryTopic) {
		this.primaryTopic = primaryTopic;
	}

	@Override
	public String toString() {
		return "Question [Id=" + Id + ", Question=" + Question + ", choice_1=" + choice_1 + ", choice_2=" + choice_2
				+ ", choice_3=" + choice_3 + ", choice_4=" + choice_4 + ", answer=" + answer + ", level=" + level
				+ ", second_Topics=" + second_Topics + ", primaryTopic=" + primaryTopic + "]";
	}

}
