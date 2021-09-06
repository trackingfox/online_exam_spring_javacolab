package com.JPA.onlineExam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.JPA.onlineExam.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
