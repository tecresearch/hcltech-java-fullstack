package com.cetpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Department 
{
	@Id
	@GeneratedValue(generator = "dept_seq")
	@SequenceGenerator(name = "dept_seq",initialValue = 101,allocationSize = 1)
	private int deptId;
	private String deptName;
	private String deptHeadName;
	private int totalEmployees;
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDeptHeadName() {
		return deptHeadName;
	}
	public void setDeptHeadName(String deptHeadName) {
		this.deptHeadName = deptHeadName;
	}
	public int getTotalEmployees() {
		return totalEmployees;
	}
	public void setTotalEmployees(int totalEmployees) {
		this.totalEmployees = totalEmployees;
	}
	
}
