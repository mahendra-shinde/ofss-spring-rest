package com.mahendra.services;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahendra.dao.JobRepository;
import com.mahendra.entities.Job;

@Service
public class JobService {

	@Autowired private JobRepository repository;
	
	@PostConstruct ///  Call after instance of ready !!!
	public void init() {
		System.out.println("Using repository object "+ repository.getClass().getName());
	}
	
	public void create(Job job) {
		if(repository.existsById(job.getJobId()))
			throw new RuntimeException("Job already exists !");
		repository.save(job);
	}
	
	public Job findById(String jobId) {
		Optional<Job> job = repository.findById(jobId);
		if(job.isPresent())
			return job.get();
		else
			throw new RuntimeException("Job doesn't exist");
	}
	
	public List<Job> getAll(){
		return repository.findAll();
	}
}
