package com.JPA.onlineExam.model;

public class QuestionTemp {

	private long Id;
	private String Question;
	private String choice_1;
	private String choice_2;
	private String choice_3;
	private String choice_4;
	private String answer;
	private String primaryTopic;
	private String secondaryTopics;

//	private TestPaper test;

//	private Topic primaryTopic;
//
//	private List<Topic> secondaryTopic;

	private String tag;

	private String level;

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

	public String getPrimaryTopic() {
		return primaryTopic;
	}

	public void setPrimaryTopic(String primaryTopic) {
		this.primaryTopic = primaryTopic;
	}

	public String getSecondaryTopics() {
		return secondaryTopics;
	}

	public void setSecondaryTopics(String secondaryTopics) {
		this.secondaryTopics = secondaryTopics;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "QuestionTemp [Id=" + Id + ", Question=" + Question + ", choice_1=" + choice_1 + ", choice_2=" + choice_2
				+ ", choice_3=" + choice_3 + ", choice_4=" + choice_4 + ", answer=" + answer + ", primaryTopic="
				+ primaryTopic + ", secondaryTopics=" + secondaryTopics + ", tag=" + tag + ", level=" + level + "]";
	}

}
