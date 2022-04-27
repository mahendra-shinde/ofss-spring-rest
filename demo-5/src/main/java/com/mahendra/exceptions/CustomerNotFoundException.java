package com.mahendra.exceptions;

public class CustomerNotFoundException extends RuntimeException {

	public CustomerNotFoundException() {
		super("Customer you are searching for doesn't exist");
		
	}

	public CustomerNotFoundException(int custId) {
		super("There is NO customer with id "+custId);
	}
	
}
