package com.JPA.onlineExam.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.JPA.onlineExam.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@EntityGraph(type = EntityGraphType.FETCH, attributePaths = { "TestPaperList", "TestPaperList.topics",
			"TestPaperList.questionSet", "attemptTestPaperList", "attemptTestPaperList.questionAnswersSet", "friends",
			"activity", "TopicWiseScoreList" })
	@Query("FROM User ")
	Set<User> FetchUserFinal();

	@EntityGraph(type = EntityGraphType.FETCH, attributePaths = { "TestPaperList", "TestPaperList.topics",
			/* "TestPaperList.questionSet", */ "attemptTestPaperList", "attemptTestPaperList.questionAnswersSet",
			/* "friends", */ "activity", "TopicWiseScoreList" })
	@Query("FROM User ")
	List<User> FetchUser();

//	@EntityGraph(type = EntityGraphType.FETCH, attributePaths = { "TestPaperList", "TestPaperList.topics",
//			"TestPaperList.questionSet", "attemptTestPaperList", "attemptTestPaperList.questionAnswersSet", "friends",
//			"activity", "TopicWiseScoreList" })
//	@Query("Select percentile, score from score where score.Id=(Select score_Id from topicwisescore where topic_id =(Select TopicWiseScoreList_Id from TopicWiseScoreList where User_Id =(Select Id from user where userName =?1 AND password = ?2))) ")
//	Score FetchUserScoreDetails(long Id);

//-------------------------------------------------------------------------------------------------------------------	

//-------------------------------------------------------------------------------------------------------------------
//	@EntityGraph(type = EntityGraphType.FETCH, attributePaths = { "TestPaperList", "TestPaperList.topics",
//			"TestPaperList.questionSet", "attemptTestPaperList", "attemptTestPaperList.questionAnswersSet", "friends",
//			"activity", "TopicWiseScoreList" })
//	@Query("Select user.userName from user where Id=(Select friends_Id from user_user where user_Id = (Select Id from user where userName =?1 AND password = ?2 )) ")
//	List<User> FetchUserFriends(long Id);

	/*
	 * --------------------------------------------------------------------------
	 * Methods below added by Towshif (PLEASE READ BEFORE USE )
	 * --------------------------------------------------------------------------
	 */

	@EntityGraph(type = EntityGraphType.FETCH, attributePaths = { "friends" })
	@Query("select a FROM User a LEFT JOIN FETCH a.friends where a.Id>=2 and a.Id <=7")
	List<User> fetchUsersFriends();

	/* Fetch all Users bw id 2,8 and get TestPapers for each user */
	@EntityGraph(type = EntityGraphType.FETCH, attributePaths = { "TestPaperList" })
	@Query("select a FROM User a LEFT JOIN FETCH a.TestPaperList where a.Id>=2 and a.Id <=7")
	List<User> fetchUsersTestpaper();

	/*
	 * Fetch all Users bw id 2,8 and for each user : get TestPapers and Topic of
	 * each test paper
	 */
	@EntityGraph(type = EntityGraphType.FETCH, attributePaths = { "TestPaperList", "TestPaperList.topics" })
	@Query("select a FROM User a LEFT JOIN FETCH a.TestPaperList where a.Id>=2 and a.Id <=7")
	List<User> fetchUsersTestpaperTopics();

	/*
	 * Fetch all Users bw id: 5,7 and for each user : get TestPapers and Topic of
	 * each test paper
	 */
	@EntityGraph(type = EntityGraphType.FETCH, attributePaths = { "TestPaperList", "TestPaperList.topics",
			"TestPaperList.questionSet" })
	@Query("select a FROM User a LEFT JOIN FETCH a.TestPaperList where a.Id>= :start and a.Id <= :end")
	List<User> fetchUserTestpaperQuestionsTopics(@Param("start") long start, @Param("end") long end);

	/*
	 * Fetch a single user by ID : get TestPapers and Topic of each test paper
	 */
	@EntityGraph(type = EntityGraphType.FETCH, attributePaths = { "TestPaperList", "TestPaperList.questionSet" })
	@Query("select a FROM User a JOIN FETCH a.TestPaperList where a.Id= :userID")
	User fetchAUserTestpaperQuestionsTopics(@Param("userID") long userID);

}
