package com.JPA.onlineExam.repoTest;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

//@Configuration
//@EnableJpaRepositories(basePackages = { "com.JPA.onlineExam.repository" })
public class ApplicationConfig {

	@Bean
	public LocalEntityManagerFactoryBean entityManagerFactory() {
		LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
		factoryBean.setPersistenceUnitName("JPA_Online_Exam");
		return factoryBean;

	}

	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {

		JpaTransactionManager transactionManager = new JpaTransactionManager();

		transactionManager.setEntityManagerFactory(emf);
		return transactionManager;
	}

}
