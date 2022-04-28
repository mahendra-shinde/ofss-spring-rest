package com.mahendra.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mahendra.entities.Job;

@Repository	/// Spring annotation for DAO component
public interface JobRepository extends JpaRepository<Job, String> {
	
}
