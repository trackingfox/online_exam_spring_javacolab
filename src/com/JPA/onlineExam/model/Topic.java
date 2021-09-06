package com.JPA.onlineExam.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Topic")
public class Topic {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private long Id;

	private String titletopic;
	private String content;

//	@OneToMany(fetch = FetchType.LAZY)
//	private Set<Testpaper> testpapers;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getTitletopic() {
		return titletopic;
	}

	public void setTitletopic(String titletopic) {
		this.titletopic = titletopic;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Topic [Id=" + Id + ", titletopic=" + titletopic + ", content=" + content + "]";
	}

}
