package com.JPA.onlineExam.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.JPA.onlineExam.model.Topic;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {

	@Query("FROM Topic where Id>=1 AND Id <=8")
	Set<Topic> FetchTopics();

}
