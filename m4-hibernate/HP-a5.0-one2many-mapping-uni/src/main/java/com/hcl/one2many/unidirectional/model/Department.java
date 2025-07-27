package com.hcl.one2many.unidirectional.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="a5_department_uni")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int did;
	private String name;
	private String head;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Employee> employeeList;
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Department(String name, String head, List<Employee> employeeList) {
		 
		this.name = name;
		this.head = head;
		this.employeeList = employeeList;
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
	public List<Employee> getEmployeeList() {
		return employeeList;
	}
	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}
	
	@Override
	public String toString() {
		return "Department [did=" + did + ", name=" + name + ", head=" + head + ", employeeList=" + employeeList + "]";
	}
	
	
}
