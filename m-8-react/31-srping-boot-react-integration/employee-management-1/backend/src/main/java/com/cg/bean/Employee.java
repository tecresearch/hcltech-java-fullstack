package com.cg.bean;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Employee {
	@Id
	private int empid;
	@NotNull(message = "Name should not be null")
	@NotBlank(message = "Name can not be blank")
	private String name;
	@JsonFormat(pattern = "dd-MM-yyyy")
	@Column(name = "date_of_birth")
	private LocalDate dob;	
	@NotNull(message = "Salary Should not be null")
	@Min(value = 25000, message = "Salary Should not less than 25k")
	private Double salary;
	@Email(message = "Invalid Email")
	private String email;
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public Employee(int empid, String name, LocalDate dob, Double salary, String email) {
		super();
		this.empid = empid;
		this.name = name;
		this.dob = dob;
		this.salary = salary;
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

}
