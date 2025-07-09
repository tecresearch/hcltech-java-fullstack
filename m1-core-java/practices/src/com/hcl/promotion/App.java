package com.hcl.promotion;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee emp=new Employee("Brijesh",'M');
        
		System.out.println(emp);
		
		emp.promoteEmp();
		System.out.println(emp);
		
		emp.promoteEmp();
		System.out.println(emp);
	
		emp.promoteEmp();
		System.out.println(emp);
		emp.applyForLWP();
		System.out.println(emp);
		
		Employee emp2=new Employee("Rohit",'M',4.0,"ITA",0.0,"active");
		

		System.out.println(emp2);
		
		emp2.promoteEmp();
		System.out.println(emp2);
		
		emp2.promoteEmp();
		System.out.println(emp2);
	
		emp2.promoteEmp();
		System.out.println(emp2);
		emp2.applyForLWP();
		System.out.println(emp2);
//		
	}

}
