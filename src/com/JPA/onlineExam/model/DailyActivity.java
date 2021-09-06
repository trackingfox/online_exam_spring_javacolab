package com.JPA.onlineExam.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DailyActivity")
public class DailyActivity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private long Id;
	private Date day;
	private String testlink;

	public Date getDay() {
		return day;
	}

	public void setDay(Date day) {
		this.day = day;
	}

	public String getTestlink() {
		return testlink;
	}

	public void setTestlink(String testlink) {
		this.testlink = testlink;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	@Override
	public String toString() {
		return "DailyActivity [Id=" + Id + ", day=" + day + ", testlink=" + testlink + "]";
	}

	// collection of task

	// map with user

}
