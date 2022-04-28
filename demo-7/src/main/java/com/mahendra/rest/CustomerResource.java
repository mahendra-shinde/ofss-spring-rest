package com.mahendra.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mahendra.daos.CustomerDAO;
import com.mahendra.models.Customer;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
/// Test URL http://localhost:8080/api/customer/
@RequestMapping("/api/customer")
@Tag(description = "Customer Service REST Ednpoints", name = "Customer Resource")
public class CustomerResource {

	@Autowired
	private CustomerDAO dao;

	@GetMapping(produces = { "application/xml", "application/json" })
	@Operation(description = "List all customers", method = "GET")
	public List<Customer> listCustomers() {
		return dao.getAll();
	}
	
	@GetMapping(produces = "text/html")
	@Operation(description = "Dummy method",deprecated = true,  method = "GET")
	public String process() {
		return "<h2>Hello World</h2>";
	}
	
	@GetMapping(produces="text/csv")
	@Operation(description = "Dummy method",deprecated = true,  method = "GET")
	public String processText() {
		List<Customer> customers = dao.getAll();
		StringBuilder str = new StringBuilder();
		for(Customer cust: customers) {
			str.append(cust.getCustId()+", ").append(cust.getFirstName()).append(", ").append(cust.getLastName()).append(", ").append(cust.getPan());
			str.append("\n");
		}
		return str.toString();
	}
	
	@PostMapping(consumes= {"application/json","application/xml"})
	@Operation(description = "Create new Customer record")

	public String create(@RequestBody Customer customer) {
		dao.addCustomer(customer);
		return "New customer added ";
	}
	
	// Actually "Replaces" the old record with new record
	@PutMapping(value="/{id}", consumes= {"application/json","application/xml"},produces={"application/json","application/xml"})
	public Customer update(@PathVariable("id") int id, @RequestBody Customer customer) {
		Customer oldCust = dao.findById(id);
		oldCust.setFirstName(customer.getFirstName());
		oldCust.setLastName(customer.getLastName());
		oldCust.setPan(customer.getPan());
		return customer;
	}
	
	@DeleteMapping("/{id}")
	public String deleteById(@PathVariable int id) {
		Customer cust = dao.findById(id);
		dao.delete(cust);
		return "Record deleted !";
	}
	
	@PatchMapping(value="/{id}",consumes="application/json", produces="application/json")
	public Customer update(@PathVariable ("id") int id, @RequestBody Map<String, String> fields ) {
		Customer oldCustomer = dao.findById(id);
		if(fields.containsKey("firstName"))
			oldCustomer.setFirstName(fields.get("firstName"));
		if(fields.containsKey("lastName"))
			oldCustomer.setLastName(fields.get("lastName"));
		if(fields.containsKey("pan"))
			oldCustomer.setPan(fields.get("pan"));
		return oldCustomer;
	}
}
