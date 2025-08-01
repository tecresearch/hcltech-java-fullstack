package com.hcl.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="first_lavel_cache_emp")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long sapId;
	private String name;
	private String emailId;
	private int age;
	private String company;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(  String name, String emailId, int age, String company) {
		super();
		this.sapId = sapId;
		this.name = name;
		this.emailId = emailId;
		this.age = age;
		this.company = company;
	}
	public long getSapId() {
		return sapId;
	}
	public void setSapId(long sapId) {
		this.sapId = sapId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	@Override
	public String toString() {
		return "Employee [sapId=" + sapId + ", name=" + name + ", emailId=" + emailId + ", age=" + age + ", company="
				+ company + "]";
	}
	
	
}

