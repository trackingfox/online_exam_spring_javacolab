package com.JPA.onlineExam.repoTest;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.JPA.onlineExam.service.BookService;

public class bookTest_appconfig {

	@Test
	public void callbook() {

		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
		appContext.scan("com.JPA.onlineExam");
		appContext.refresh();
		BookService bookserv = (BookService) appContext.getBean("BookService");

		bookserv.BookRun();
		appContext.close();

	}

}
