package com.hcl.employee;

public class Employee {
 private long empId;
 private double empSalary;
 private float empTax;
 private int empDaysofWork;

 
 
 public Employee(long empId, double empSalary, double d, int empDaysofWork) {
	super();
	this.empId = empId;
	this.empSalary = empSalary;
	this.empTax = (float) d;
	this.empDaysofWork = empDaysofWork;
}



public long getEmpId() {
	return empId;
}



public void setEmpId(long empId) {
	this.empId = empId;
}



public double getEmpSalary() {
	return empSalary;
}



public void setEmpSalary(double empSalary) {
	this.empSalary = empSalary;
}



public float getEmpTax() {
	return empTax;
}



public void setEmpTax(float empTax) {
	this.empTax = empTax;
}



public int getEmpDaysofWork() {
	return empDaysofWork;
}



public void setEmpDaysofWork(int empDaysofWork) {
	this.empDaysofWork = empDaysofWork;
}



public float calculatePF() {
	 float pfRate=(float) 10.5;
	 return pfRate;
	
 }
 
}
