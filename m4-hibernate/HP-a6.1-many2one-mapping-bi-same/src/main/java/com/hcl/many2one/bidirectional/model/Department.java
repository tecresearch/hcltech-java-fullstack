package com.hcl.many2one.bidirectional.model;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="a6_department_bi")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int did;
	private String name;
	private String head;
	@OneToMany(mappedBy = "department")
	private List<Employee> employees;
	
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Department(String name, String head,List<Employee> employees) {
		 
		this.name = name;
		this.head = head;
		this.employees=employees;
		
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	
	
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	@Override
	public String toString() {
		return "Department [did=" + did + ", name=" + name + ", head=" + head +  ",Employess"+employees+"]";
	}
	
	
}
