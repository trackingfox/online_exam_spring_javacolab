package com.JPA.onlineExam.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.JPA.onlineExam.model.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

	@EntityGraph(type = EntityGraphType.FETCH, attributePaths = { "second_Topics", "primaryTopic" })
	@Query("FROM Question where Id>=FLOOR(RAND()*(25-10+1))+10 AND Id<FLOOR(RAND()*(50-10+1))+30 ")
	Set<Question> fetchQuestions();

}
