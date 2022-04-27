package com.mahendra;

import java.util.Collections;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.mahendra.models.Customer;

@SpringBootApplication
public class Demo4Application implements CommandLineRunner {

	private RestTemplate template = new RestTemplate();
	// URL for REST Service defined in demo-3 
	private  final static String BASE_URL="http://localhost:8080/api/customer";
	
	public static void main(String[] args) {
		SpringApplication.run(Demo4Application.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Requesting HTML Output !");
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<>("body",headers);
		//ResponseEntity<String> output = template.exchange(BASE_URL,HttpMethod.GET, entity, String.class);
		ResponseEntity<Customer[]> output = template.exchange(BASE_URL,HttpMethod.GET, entity, Customer[].class);
		System.out.println("Response Status Code : "+ output.getStatusCodeValue());
		//System.out.println("Response Text : "+ output.getBody());
		System.out.println("Found number of customers : "+ output.getBody().length);
		for(Customer c: output.getBody()) {
			System.out.println("First Name: "+c.getFirstName());
			System.out.println("Last Name: "+c.getLastName());
		}
		
	}

}
