package com.JPA.onlineExam.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.JPA.onlineExam.model.AttemptedTest;

@Repository
public interface AttemptedTestRepository extends JpaRepository<AttemptedTest, Long> {

	@EntityGraph(type = EntityGraphType.FETCH, attributePaths = { "test", "test.topics", "test.questionSet",
			"questionAnswersSet" })
	@Query("FROM AttemptedTest where Id>= ?1 AND Id <= ?2")
	Set<AttemptedTest> FetchAttemptedTestPaper1(long start, long end);

//	@EntityGraph(type = EntityGraphType.FETCH, attributePaths = { "test", "test.topics", "test.questionSet",
//			"questionAnswersSet" })
//	@Query("Select * FROM TestPaper where Id=(Select test_Id from AttemptedTest where Id = ?1)")
//	AttemptedTest createOneAttemptedTest(TestPaper testpaper);
}
