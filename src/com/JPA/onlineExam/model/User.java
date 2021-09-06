package com.JPA.onlineExam.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.Nullable;

@Entity
@Table(name = "User")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private long Id;

	@Column(name = "userName")
	private String userName;

	@Column(name = "password")
	private String password;

	@ManyToMany(fetch = FetchType.LAZY)
	private Set<TestPaper> TestPaperList;

	@OneToMany(fetch = FetchType.LAZY)
	private Set<AttemptedTest> attemptTestPaperList;

	// allows nullable
	@Nullable
	@ManyToMany(fetch = FetchType.LAZY)
	private Set<User> friends;

	@OneToMany(fetch = FetchType.LAZY)
	private Set<DailyActivity> activity;

	@OneToMany(fetch = FetchType.LAZY)
	private Set<TopicWiseScore> TopicWiseScoreList;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<TestPaper> getTestPaperList() {
		return TestPaperList;
	}

	public void setTestPaperList(Set<TestPaper> testPaperList) {
		TestPaperList = testPaperList;
	}

	public Set<AttemptedTest> getAttemptTestPaperList() {
		return attemptTestPaperList;
	}

	public void setAttemptTestPaperList(Set<AttemptedTest> attemptTestPaperList) {
		this.attemptTestPaperList = attemptTestPaperList;
	}

	public Set<User> getFriends() {
		return friends;
	}

	public void setFriends(Set<User> friends) {
		this.friends = friends;
	}

	public Set<DailyActivity> getActivity() {
		return activity;
	}

	public void setActivity(Set<DailyActivity> activity) {
		this.activity = activity;
	}

	public Set<TopicWiseScore> getTopicWiseScoreList() {
		return TopicWiseScoreList;
	}

	public void setTopicWiseScoreList(Set<TopicWiseScore> topicWiseScoreList) {
		TopicWiseScoreList = topicWiseScoreList;
	}

	@Override
	public String toString() {
		return "User [Id=" + Id + ", userName=" + userName + ", password=" + password + ", TestPaperList="
				+ TestPaperList + ", attemptTestPaperList=" + attemptTestPaperList /* + ", friends=" + friends */
				+ ", activity=" + activity + ", TopicWiseScoreList=" + TopicWiseScoreList + "]";
	}

}
