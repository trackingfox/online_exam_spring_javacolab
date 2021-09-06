package com.JPA.onlineExam.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.JPA.onlineExam.model.TestPaper;

@Repository
public interface TestPaperRepository extends JpaRepository<TestPaper, Long> {

	@EntityGraph(type = EntityGraphType.FETCH, attributePaths = { "topics", "questionSet" })
	@Query("FROM TestPaper where Id>=1 AND Id<=8 ")
	Set<TestPaper> fetchTestPapers();

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

}
