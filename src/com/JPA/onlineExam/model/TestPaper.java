package com.JPA.onlineExam.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TestPaper")
public class TestPaper {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private long Id;

	@Column(name = "testName")
	private String testName;

	@Column(name = "testLevel")
	private Integer testLevel;

	@Column(name = "testPaperType")
	private Integer testPaperType;// 1-global, 2-topic wise testPaper, 3- miscellaneous, 4- custom

	@ManyToMany(fetch = FetchType.LAZY)
	private List<Topic> topics;

	@ManyToMany(fetch = FetchType.LAZY)
	private Set<Question> questionSet;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public Integer getTestLevel() {
		return testLevel;
	}

	public void setTestLevel(Integer testLevel) {
		this.testLevel = testLevel;
	}

	public void setTestPaperType(Integer testPaperType) {
		this.testPaperType = testPaperType;
	}

	public int getTestPaperType() {
		return testPaperType;
	}

	public void setTestPaperType(int testPaperType) {
		this.testPaperType = testPaperType;
	}

	public List<Topic> getTopics() {
		return topics;
	}

	public void setTopics(List<Topic> topics2) {
		this.topics = topics2;
	}

	public Set<Question> getQuestionSet() {
		return questionSet;
	}

	public void setQuestionSet(Set<Question> questionSet) {
		this.questionSet = questionSet;
	}

	@Override
	public String toString() {
		return "TestPaper [Id=" + Id + ", testName=" + testName + ", testLevel=" + testLevel + ", testPaperType="
				+ testPaperType + ", topics=" + topics + ", questionSet=" + questionSet + "]";
	}

}
