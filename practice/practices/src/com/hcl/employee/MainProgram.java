package com.hcl.employee;

public class MainProgram {

	public static void main(String[] args) {
		
		Employee e1=new Employee(345,10000,9.5,24);
		
		System.out.println("The id of Employee is "+e1.getEmpId());
		System.out.println("The id of Employee is "+e1.getEmpSalary());
		System.out.println("The id of Employee is "+e1.getEmpTax());
		System.out.println("The id of Employee is "+e1.getEmpDaysofWork());
		System.out.println("The id of Employee is "+e1.calculatePF());
	}

}
