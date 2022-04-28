package com.mahendra.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mahendra.entities.Job;
import com.mahendra.services.JobService;

@RestController
@RequestMapping("/api/jobs")
public class JobResource {

	@Autowired private JobService service;
	
	@GetMapping(value="/{id}", produces="application/json")
	public Job findJob(@PathVariable("id") String id){
		return service.findById(id);
	}
	
	@GetMapping(produces="application/json")
	public List<Job> loadJobs(){
		return service.getAll(); 
	}
}
