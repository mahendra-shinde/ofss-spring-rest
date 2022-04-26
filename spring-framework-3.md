## Spring MVC Demo

1. Customer Model class
	```java
	package: com.mahendra.models
	Class: Customer
	
	private Integer custId;
	private String firstName;
	private String lastName;
	private String pan;
	
	//Gerenerate Getters/Setters and Constuctors
	```
	
2. Customer DAO

	```java
	package com.mahendra.daos;

	import java.util.Collections;
	import java.util.LinkedList;
	import java.util.List;
	import java.util.logging.Logger;

	import org.springframework.stereotype.Component;

	import com.mahendra.models.Customer;

	@Component 
	public class CustomerDAO {
		private List<Customer> customers=null;
		
		private static Logger log = Logger.getLogger("CustomerDAO"); 
		
		public CustomerDAO() {
			log.info("Customer DAO Instance created !");
			customers = new LinkedList<>();
			customers.add(new Customer(101,"Amitabh","Shrivastav","1234ABCD"));
			customers.add(new Customer(102,"Rajiv","Bhatia","1254AXCD"));
		}
		
		public Customer findById(Integer custId) {
			for(Customer cust : customers) {
				if(cust.getCustId() == custId) {
					log.info("Found a match !");
					return cust;
				}
			}
			log.warning("Could not find any matching record");
			return null;
		}
		
		public void addCustomer(Customer cust) {
			customers.add(cust);
		}
		
		public List<Customer> getAll(){
			return Collections.unmodifiableList(customers);
		}
	}
	```
3.	Customer Controller class 

	```java
	package com.mahendra.controller;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.RequestMapping;

	import com.mahendra.daos.CustomerDAO;
	import com.mahendra.models.Customer;

	@Controller						// A Controller is part of "MVC" Architecture
	@RequestMapping("/customer")	// Handles "HTTP"/Web Request for URL /customer
	public class CustomerController {

		@Autowired private CustomerDAO dao;
		//Setter Injection
		public void setCustomerDAO(CustomerDAO dao) {
			this.dao =dao;
		}
		
		@GetMapping("/{custid}")	// Path Variable to accept the input
		public String find(@PathVariable("custid") int custId, Model model) {
			Customer cust = dao.findById(custId);
			if(cust!=null) {
				// Expose these "attributes" for use in "EL" expressions
				model.addAttribute("msg","Customer found!");
				model.addAttribute("cust",cust);
			}
			else
				model.addAttribute("msg","Customer not found!");
			return "customer";	// VIEW Page (Dynamic Template // actual path : /src/main/resources/templates/customer.html
		}
		
	}

	```

5.	Customer HTML (Thymeleaf) template page in `/src/main/resources/templates/customer.html`

	```xhtml
	<!DOCTYPE html>
	<!-- This document is NOT plain HTML but a template ! -->
	<html xmlns:th="https://thymeleaf.org">
	<head>
	<meta charset="UTF-8">
	<title>Customer details</title>
	</head>
	<body>

	<!--  SpringEL : Spring Expression Language
			Simplified Definition EL : Language used for Extracting DATA !
				
	-->
	<h3 th:text="${msg}"></h3>


	<table th:if="${cust != null}">
		<tr>
			<td>Customer ID</td>
			<td><span th:text="${cust.custId}"></span> </td>
		</tr>
		<tr>
			<td>Customer Name:</td>	
			<td><span th:text="${cust.firstName}"></span> 
				<span th:text="${cust.lastName}"></span></td>
		</tr>
		<tr>
			<td>PAN</td>
			<td><span th:text="${cust.pan}"></span></td>
		</tr>
	</table>
	</body>
	</html>
	```