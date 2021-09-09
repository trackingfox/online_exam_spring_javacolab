package com.JPA.onlineExam.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.JPA.onlineExam.model.Question;
import com.JPA.onlineExam.model.TestPaper;
import com.JPA.onlineExam.model.Topic;

@Repository
public interface TestPaperRepository extends JpaRepository<TestPaper, Long> {

	@EntityGraph(type = EntityGraphType.FETCH, attributePaths = { "topics", "questionSet",
			"questionSet.second_Topics" })
	@Query("FROM TestPaper where Id>=1 AND Id<=8 ")
	Set<TestPaper> fetchTestPapers();

	@EntityGraph(type = EntityGraphType.FETCH, attributePaths = { "topics", /* "questionSet" */ })
	@Query("FROM TestPaper where Id>=1 AND Id<=8 ")
	Set<TestPaper> fetchTestPapersTopics();

//	@EntityGraph(type = EntityGraphType.FETCH, attributePaths = { "topics", "questionSet" })
//	@Query("FROM TestPaper where topic_Id= ?1)")
//	Set<TestPaper> fetchGlobalTestPapers(long Id);

//	@EntityGraph(type = EntityGraphType.FETCH, attributePaths = { "topics", "questionSet" })
//	@Query("FROM TestPaper where topic_Id= ?1)")
//	Set<TestPaper> fetchTopicWiseTestPapers(long Id);

//	@EntityGraph(type = EntityGraphType.FETCH, attributePaths = { "topics", "questionSet" })
//	@Query("FROM TestPaper where topic_Id= ?1)")
//	Set<TestPaper> fetchMiscellaneousTestPapers(long Id);

//	@EntityGraph(type = EntityGraphType.FETCH, attributePaths = { "topics", "questionSet" })
//	@Query("FROM TestPaper where topic_Id= ?1)")
//	Set<TestPaper> fetchCustomTestPapers(List<Long>Id, int no_Oftestpapers);

	/*
	 * The Code below is written by Towshif
	 */

//	@Query("select a FROM TestPaper a LEFT JOIN FETCH a.topics LEFT JOIN FETCH a.questionSet  where a.Id>=1 AND a.Id<=3 ")
//	@Query("select a FROM TestPaper a LEFT JOIN FETCH a.topics where a.Id>=1 AND a.Id<=3 ")
//	@Query(value = "SELECT * FROM TestPaper", nativeQuery = true)
//	@Query("FROM TestPaper where Id>=1 AND Id<=3  ")
//	@Query("SELECT DISTINCT a FROM TestPaper a LEFT JOIN FETCH a.topics LEFT JOIN FETCH a.questionSet where a.Id>=1 AND a.Id<=3  ")
//	@Query("select a FROM TestPaper a LEFT JOIN FETCH a.topics where a.Id>=1 AND a.Id<=3 ")
//	@EntityGraph(type = EntityGraphType.FETCH, value = "get-entity-graph")

//// To use this make topics LAZY and QUESTION EAGER in @entity
//	@EntityGraph(type = EntityGraphType.FETCH, attributePaths = { "topics", "questionSet" })
//	@Query("FROM TestPaper where Id>=1 AND Id<=3  ")
//	List<TestPaper> fetchTestPapers();

	// To use this make topics LAZY and QUESTION EAGER in @entity
	@EntityGraph(type = EntityGraphType.FETCH, attributePaths = { "topics" })
	@Query("select a FROM TestPaper a JOIN FETCH a.topics where a.Id>=1 AND a.Id<=3  ")
	List<TestPaper> fetchTestPapers2();

	@Query("FROM Question where Id>=FLOOR(RAND()*(25-10+1))+10 AND Id<FLOOR(RAND()*(50-10+1))+30 ")
	List<Question> fetchQuestions();

	@Query("FROM Topic where rand() <= 0.4")
	List<Topic> FetchTopics();

//	@Override
//	@EntityGraph(type = EntityGraphType.FETCH, attributePaths = { "testName", "topics" })
//	List<TestPaper> findAll();

	@Override
	@EntityGraph(type = EntityGraphType.FETCH, value = "get-entity-graph")
//	@EntityGraph(attributePaths = { "topics", "questionSet" })
	List<TestPaper> findAll();

//	@Query("FROM TestPaper where Id>=1 AND Id<=3  ") // Error
	// As long as you fetch at most one collection using JOIN FETCH, we r fine.
//	@Transactional
//	@EntityGraph(attributePaths = { "testName", "topics" })
//	@Query("FROM TestPaper a LEFT JOIN FETCH a.topics where a.Id between 1 and 3")
//	List<TestPaper> fetchTestPapers();

}
