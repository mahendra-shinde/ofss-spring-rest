package com.mahendra.daos;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.stereotype.Component;

import com.mahendra.exceptions.CustomerNotFoundException;
import com.mahendra.exceptions.DuplicateCustomerException;
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
		throw new CustomerNotFoundException(custId);
	}
	
	public void addCustomer(Customer cust) {
		if(doesExists(cust.getCustId())) {
			throw new DuplicateCustomerException(cust.getCustId());
		}
		customers.add(cust);
		System.out.println("Adding new customer "+cust.getLastName());
	}
	
	public List<Customer> getAll(){
		return Collections.unmodifiableList(customers);
	}
	
	public void delete(Customer customer) {
		if(! doesExists(customer.getCustId())) {
			throw new CustomerNotFoundException(customer.getCustId());
		}
		customers.remove(customer);
	}
	
	private boolean doesExists(int custId) {
		for(Customer cust : customers) {
			if(cust.getCustId() == custId) {
				return true;
			}
		}
		return false;
	}
}
