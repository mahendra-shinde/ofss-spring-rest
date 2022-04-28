package com.mahendra.models;

import java.io.Serializable;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Customer implements Serializable {
	
	private Integer custId;
	private String firstName;
	private String lastName;
	private String pan;
	
	public Integer getCustId() {
		return custId;
	}
	public void setCustId(Integer custId) {
		this.custId = custId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Customer(Integer custId, String firstName,
			String lastName, String pan) {
		super();
		this.custId = custId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.pan=pan;
	}
	
	
}
