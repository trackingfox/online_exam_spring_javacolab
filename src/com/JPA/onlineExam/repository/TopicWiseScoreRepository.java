package com.JPA.onlineExam.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.JPA.onlineExam.model.TopicWiseScore;

@Repository
public interface TopicWiseScoreRepository extends JpaRepository<TopicWiseScore, Long> {

	@Query("FROM TopicWiseScore  where Id>= ?1 AND Id<= ?2")
	Set<TopicWiseScore> Fetch_TopicWiseScoreList(long start, long end);
}
