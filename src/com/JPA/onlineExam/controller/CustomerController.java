package com.JPA.onlineExam.controller;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JPA.onlineExam.model.Customer;
import com.JPA.onlineExam.repository.CustomerRepository;
import com.JPA.onlineExam.service.PopulateDatabaseService;

@RestController
@RequestMapping(value = "/customers", produces = { MediaType.APPLICATION_JSON_VALUE })
public class CustomerController {

	@Autowired
	private CustomerRepository repository;

	@Autowired
	private PopulateDatabaseService populateService;

	public PopulateDatabaseService getPopulateService() {
		return populateService;
	}

	public void setPopulateService(PopulateDatabaseService populateService) {
		this.populateService = populateService;
	}

	public CustomerRepository getRepository() {
		return repository;
	}

	public void setRepository(CustomerRepository repository) {
		this.repository = repository;
	}

	@GetMapping(value = "/allcustomers")
	public List<Customer> getAllCustomers() {

		return repository.findAll();
	}

	@GetMapping(value = "/ping")
	public String ping() {

		return "hello world hello cbb";
	}

	@GetMapping(value = "/populate")
	public String populateCustomer() throws IllegalStateException, FileNotFoundException {

		// populateService.importCustomerFromCsv();
		populateService.populateCustomer();

		return "populate done ok hello";
	}
}
