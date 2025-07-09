package com.hcl.promotion;

public class Employee {
	String name;
	char gender;
	double yearsOfExp;
	String designation;
	double basicSalary;
	String status;
	
	
	public Employee(String name,char gender) {
	          this(name,gender,0.0,null,0.0,null);
		
	}
	
	 public Employee(String name, char gender, Double yearsOfExp, String designation, Double basicSalary, String status) {
	        this.name =name;    
	        this.gender = gender;
	        if(yearsOfExp>=3) {
	        	this.designation="ITA";
	        	this.basicSalary=15000;
	        }else {
	        	this.designation="ASE";
	        	this.basicSalary=10000;
	        }
	        this.status=(status != null)?status:"Active";
	        this.yearsOfExp=yearsOfExp;
	 }

	 @Override
	public String toString() {
		return "Employee [name=" + name + ", gender=" + gender + ", yearsOfExp=" + yearsOfExp + ", designation="
				+ designation + ", basicSalary=" + basicSalary + ", status=" + status + "]";
	}
	 
	 
	 
	 
	 public double promoteEmp() {
		
		 if(this.designation=="ASE") {
			 this.designation="ITA";
			 double inc=this.basicSalary+(basicSalary*((double)5/100));
			 this.basicSalary=inc;
			 return basicSalary;
		 }
		 if(this.designation=="ITA") {
			 this.designation="AST";
			 double inc=this.basicSalary+(basicSalary*((double)8/100));
			 this.basicSalary=inc;		
			 return basicSalary;
		 }
		 if(this.designation=="AST") {
			 this.designation="ASC";
			 double inc=this.basicSalary+(basicSalary*((double)10/100));
			 this.basicSalary=inc;	
			 return basicSalary;
		 }
	
		 return basicSalary;
	 }
	 
	 public void applyForLWP() {
		 this.status="InActive";
		 this.basicSalary=0.0;
	 }
	 
	 
}
