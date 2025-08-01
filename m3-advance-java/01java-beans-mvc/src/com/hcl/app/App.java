package com.hcl.app;
import java.util.List;
import java.util.Scanner;
import com.hcl.entities.*;
import com.hcl.entities.Employee;
import com.hcl.services.EmployeeService;
import com.hcl.services.EmployeeServiceImpl;
public class App {

	public static void main(String[] args) {
		EmployeeService employeeService =new EmployeeServiceImpl();
		Scanner sc=new Scanner(System.in);
		do {
			
			
			
			System.out.println("1.Add Employee");
			System.out.println("2.Show Employees");
			System.out.println("3.Get Employee");
			System.out.println("4.Update Employee");
			System.out.println("5.Delete Employee");
			System.out.println("6. Close Application");
			System.out.println("Choice: ");
			int ch=sc.nextInt();
			switch(ch) {
			case 1:
				boolean status=employeeService.addEmployee(new Employee(101,"Brijesh Nishad",50000));
				System.out.println("Employee Added Successfully: "+status);
				System.out.println("--------------------------------------");
				break;
			case 2:
				List<Employee> employess=employeeService.getEmployees();
				System.out.println("List of Employee fetched successfully");
				System.out.println(employess);
				break;
			case 3:
				Employee emp=employeeService.getEmployeeByEmpId(101);
				System.out.println("Employee found via id: "+emp.getEmpId());
				System.out.println((emp==null)?"Not Found":emp);
				break;
			default:
				System.out.println("Invalid Input");
				
			}
		}while(true);

	}

}
