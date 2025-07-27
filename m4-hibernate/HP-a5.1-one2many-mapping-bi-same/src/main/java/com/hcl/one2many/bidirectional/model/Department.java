package com.hcl.one2many.bidirectional.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "a5_department_bi")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int did;
	private String name;
	private String head;

	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Employee> employees = new ArrayList<>();

	// Helper methods
	public void addEmployee(Employee employee) {
		employees.add(employee);
		employee.setDepartment(this);
	}

	public void removeEmployee(Employee employee) {
		employees.remove(employee);
		employee.setDepartment(null);
	}

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department(String name, String head, List<Employee> employeeList) {

		this.name = name;
		this.head = head;
		this.employees = employeeList;
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
		return employees
				;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employees = employeeList;
	}

	@Override
	public String toString() {
		return "Department [did=" + did + ", name=" + name + ", head=" + head + ", employeeList=" + employees + "]";
	}

}
