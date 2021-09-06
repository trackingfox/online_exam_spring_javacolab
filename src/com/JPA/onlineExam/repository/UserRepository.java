package com.JPA.onlineExam.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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

}
