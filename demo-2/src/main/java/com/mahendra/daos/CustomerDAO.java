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
