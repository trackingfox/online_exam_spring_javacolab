package com.JPA.onlineExam.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JPA.onlineExam.model.AttemptedTest;
import com.JPA.onlineExam.model.TestPaper;
import com.JPA.onlineExam.model.TopicWiseScore;
import com.JPA.onlineExam.model.User;
import com.JPA.onlineExam.repository.AttemptedTestRepository;
import com.JPA.onlineExam.repository.TestPaperRepository;
import com.JPA.onlineExam.repository.TopicWiseScoreRepository;
import com.JPA.onlineExam.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository UserRepository;

	@Autowired
	private TestPaperRepository TestPaperRepository;

	@Autowired
	private AttemptedTestRepository AttTestRepository;

	@Autowired
	private TopicWiseScoreRepository TopiWiseScoreRepository;

//	@Autowired
//	private DailyActivity repository4;

	public void viewUserProfile() {

	}

	public void viewTestPaper() {

	}

	public void viewAttemptedTestPaper() {

	}

	// SCORE SHOWING IN DASHBOARD
	public void AverageScore() {

	}

	// LEVEL SHOWING IN DASHBOARD
	public void levelProgress() {

	}

	public void createNewUser(String username, String password) {
		User user = new User();

		Set<TestPaper> TestPaperList = TestPaperRepository.fetchTestPapers();

		user.setUserName(username);
		user.setPassword(password);
		user.setTestPaperList(TestPaperList);

	}

	public void UserLogin(int userId, String password) {

	}
//----------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------	

	public List<User> createUser() {

		User user1 = new User();
		User user2 = new User();
		User user3 = new User();
		User user4 = new User();
		User user5 = new User();
		User user6 = new User();
		User user7 = new User();
		User user8 = new User();

		List<User> userList = new ArrayList<>();

		Set<TestPaper> TestPaperList = TestPaperRepository.fetchTestPapers();

		Set<AttemptedTest> attemptTestPaperList = AttTestRepository.FetchAttemptedTestPaper1(1, 5);

		Set<TopicWiseScore> TopicWiseScoreList = TopiWiseScoreRepository.Fetch_TopicWiseScoreList(1, 1);

		user1.setUserName("Sharif");
		user1.setPassword("password1");
		user1.setTestPaperList(TestPaperList);
		user1.setAttemptTestPaperList(attemptTestPaperList);
		user1.setTopicWiseScoreList(TopicWiseScoreList);

		// user1.setFriends(friends);

		userList.add(user1);

		attemptTestPaperList = AttTestRepository.FetchAttemptedTestPaper1(6, 8);
		TopicWiseScoreList = TopiWiseScoreRepository.Fetch_TopicWiseScoreList(2, 2);
		// System.out.println("jabjk1 : " + TopicWiseScoreList);
		user2.setUserName("Ramesh");
		user2.setPassword("password2");
		user2.setTestPaperList(TestPaperList);
		user2.setAttemptTestPaperList(attemptTestPaperList);
		user2.setTopicWiseScoreList(TopicWiseScoreList);
//		 user2.setFriends(friends);

		userList.add(user2);

		attemptTestPaperList = AttTestRepository.FetchAttemptedTestPaper1(9, 16);
		TopicWiseScoreList = TopiWiseScoreRepository.Fetch_TopicWiseScoreList(3, 3);
		user3.setUserName("Nilesh");
		user3.setPassword("password3");
		user3.setTestPaperList(TestPaperList);
		user3.setAttemptTestPaperList(attemptTestPaperList);
		user3.setTopicWiseScoreList(TopicWiseScoreList);
////		user3.setFriends(friends);
//
		userList.add(user3);

		attemptTestPaperList = AttTestRepository.FetchAttemptedTestPaper1(17, 21);
		TopicWiseScoreList = TopiWiseScoreRepository.Fetch_TopicWiseScoreList(4, 4);
		user4.setUserName("Somesh");
		user4.setPassword("password4");
		user4.setTestPaperList(TestPaperList);
		user4.setAttemptTestPaperList(attemptTestPaperList);
		user4.setTopicWiseScoreList(TopicWiseScoreList);
////	    user4.setFriends(friends);
//
		userList.add(user4);

		attemptTestPaperList = AttTestRepository.FetchAttemptedTestPaper1(22, 25);
		TopicWiseScoreList = TopiWiseScoreRepository.Fetch_TopicWiseScoreList(5, 5);
		user5.setUserName("Farukh");
		user5.setPassword("password5");
		user5.setTestPaperList(TestPaperList);
		user5.setAttemptTestPaperList(attemptTestPaperList);
		user5.setTopicWiseScoreList(TopicWiseScoreList);

		userList.add(user5);

		attemptTestPaperList = AttTestRepository.FetchAttemptedTestPaper1(26, 31);
		TopicWiseScoreList = TopiWiseScoreRepository.Fetch_TopicWiseScoreList(6, 6);
		user6.setUserName("Sarukh");
		user6.setPassword("password6");
		user6.setTestPaperList(TestPaperList);
		user6.setAttemptTestPaperList(attemptTestPaperList);
		user6.setTopicWiseScoreList(TopicWiseScoreList);

		userList.add(user6);

		attemptTestPaperList = AttTestRepository.FetchAttemptedTestPaper1(32, 35);
		TopicWiseScoreList = TopiWiseScoreRepository.Fetch_TopicWiseScoreList(7, 7);
		user7.setUserName("Amir");
		user7.setPassword("password7");
		user7.setTestPaperList(TestPaperList);
		user7.setAttemptTestPaperList(attemptTestPaperList);
		user7.setTopicWiseScoreList(TopicWiseScoreList);

		userList.add(user7);

		attemptTestPaperList = AttTestRepository.FetchAttemptedTestPaper1(36, 38);
		TopicWiseScoreList = TopiWiseScoreRepository.Fetch_TopicWiseScoreList(8, 8);
		user8.setUserName("Alam");
		user8.setPassword("password8");
		user8.setTestPaperList(TestPaperList);
		user8.setAttemptTestPaperList(attemptTestPaperList);
		user8.setTopicWiseScoreList(TopicWiseScoreList);

		userList.add(user8);

//		update_userToDb();

		return userList;
	}

	public Set<User> update_userToDb() {

		List<User> userList = new ArrayList<User>();
		userList = UserRepository.FetchUser();

		Set<User> final_userList = new HashSet<User>();

		for (User u : userList) {
			Set<User> friends = new HashSet<User>();
			friends = Fetch_friendList(userList);
			if (friends.contains(u))
				friends.remove(u);

			u.setFriends(friends);
			final_userList.add(u);
		}

		return final_userList;

	}

	public Set<User> Fetch_friendList(List<User> users) {

		Collections.shuffle(users);

		int length = (int) (Math.random() * (8 - 1 + 1) + 1);

		Set<User> randomUsers = new LinkedHashSet<>(users.subList(0, length));
		return randomUsers;
	}

	public void populateUser() {
		List<User> userList = createUser();

		userList.forEach(x -> UserRepository.save(x));

	}

	public void populateFriends() {

		Set<User> final_userList = update_userToDb();
		final_userList.forEach(x -> UserRepository.save(x));

	}

}
