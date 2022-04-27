package com.mahendra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


// This is a "Cross Cutting Concern"
// Every REST Controller method will be intercepted by this class
@ControllerAdvice
public class ErrorHandler {
	
	@ExceptionHandler(value = { CustomerNotFoundException.class, DuplicateCustomerException.class })
	public ResponseEntity<String> processError(RuntimeException ex){
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}
}
