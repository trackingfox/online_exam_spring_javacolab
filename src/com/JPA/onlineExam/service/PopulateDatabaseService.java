package com.JPA.onlineExam.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JPA.onlineExam.model.Customer;
import com.JPA.onlineExam.repository.CustomerRepository;
import com.opencsv.bean.CsvToBeanBuilder;

@Service
public class PopulateDatabaseService {

	@Autowired
	private CustomerRepository repository;

	public CustomerRepository getRepository() {
		return repository;
	}

	public void setRepository(CustomerRepository repository) {
		this.repository = repository;
	}

	public void populateCustomer() throws IllegalStateException, FileNotFoundException {
		List<Customer> customerList = importCustomerFromCsv();

		customerList.forEach(x -> repository.save(x));
	}

	public List<Customer> importCustomerFromCsv() throws IllegalStateException, FileNotFoundException {

		String filename = "data/customerDBSample.csv";

		ClassLoader classloader = getClass().getClassLoader();
		String filePath = classloader.getResource(filename).getPath();
		System.out.println(filePath);

		List<Customer> CustomerList = new CsvToBeanBuilder(new FileReader(filePath)).withType(Customer.class).build()
				.parse();
		return CustomerList;
	}

	@Test
	public void importTodb() throws IllegalStateException, FileNotFoundException {

		// use persistence.xml configuration

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Online_Exam");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		List<Customer> customerlist1 = this.importCustomerFromCsv();
		customerlist1.forEach(x -> em.merge(x));
		em.getTransaction().commit();
		em.close();
		emf.close();

	}

}
