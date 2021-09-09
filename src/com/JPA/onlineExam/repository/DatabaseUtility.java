package com.JPA.onlineExam.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface DatabaseUtility {

//	@Query("DROP TABLE * ")
	public void cleanDatabase();

}
