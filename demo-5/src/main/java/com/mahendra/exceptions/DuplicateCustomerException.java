package com.mahendra.exceptions;

public class DuplicateCustomerException extends RuntimeException {

	public DuplicateCustomerException() {
		super("Customer already exists!");	
	}

	public DuplicateCustomerException(int custId) {
		super("Customer with id "+custId+" already exists!");
	}
	
}
