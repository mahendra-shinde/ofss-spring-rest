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
