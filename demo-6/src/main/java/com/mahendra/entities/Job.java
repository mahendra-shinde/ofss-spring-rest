package com.mahendra.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="JOBS")
public class Job implements Serializable {

	@Id @Column(name="JOB_ID", length = 10)
	private String jobId;
	
	@Column(name="JOB_TITLE", length=35)
	private String jobTitle;
	
	@Column(name="MIN_SALARY", precision = 8, scale = 2)
	private double minSalary;
	
	@Column(name="MAX_SALARY", precision = 8, scale = 2)
	private double maxSalary;

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public double getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(double minSalary) {
		this.minSalary = minSalary;
	}

	public double getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(double maxSalary) {
		this.maxSalary = maxSalary;
	}

	public Job() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
