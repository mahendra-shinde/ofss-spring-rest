package com.mahendra.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mahendra.daos.CustomerDAO;
import com.mahendra.models.Customer;

@RestController
/// Test URL http://localhost:8080/api/customer/
@RequestMapping("/api/customer")
public class CustomerResource {

	@Autowired
	private CustomerDAO dao;

	@GetMapping(produces = { "application/xml", "application/json" })
	public List<Customer> listCustomers() {
		return dao.getAll();
	}
	
	@GetMapping(produces = "text/html")
	public String process() {
		return "<h2>Hello World</h2>";
	}
	
	@GetMapping(produces="text/csv")
	public String processText() {
		List<Customer> customers = dao.getAll();
		StringBuilder str = new StringBuilder();
		for(Customer cust: customers) {
			str.append(cust.getCustId()+", ").append(cust.getFirstName()).append(", ").append(cust.getLastName()).append(", ").append(cust.getPan());
			str.append("\n");
		}
		return str.toString();
	}
}
