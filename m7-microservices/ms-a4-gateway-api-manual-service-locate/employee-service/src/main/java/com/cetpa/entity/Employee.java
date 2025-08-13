package com.cetpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Employee 
{
	@Id
	@GeneratedValue(generator = "emp_seq")
	@SequenceGenerator(name="emp_seq",initialValue = 101,allocationSize = 1)
	private int empId;
	private String empName;
	private String empSalary;
	private int deptId;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(String empSalary) {
		this.empSalary = empSalary;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	
}
