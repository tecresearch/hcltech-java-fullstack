package com.cetpa.model;

public class Department 
{
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
