package com.JPA.onlineExam.repoTest;

import javax.transaction.Transactional;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.JPA.onlineExam.service.BookService;

public class bookTest_applicationContext {
	@Transactional
	@Test
	public void bookcall() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		BookService bookserv = (BookService) context.getBean("BookService");
		bookserv.BookRun();
	}

}
