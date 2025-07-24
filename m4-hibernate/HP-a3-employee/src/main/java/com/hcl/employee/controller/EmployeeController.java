package com.hcl.employee.controller;

import java.util.Scanner;

import com.hcl.employee.model.Employee;
import com.hcl.employee.service.EmployeeService;
import com.hcl.employee.service.impl.EmployeeServiceImpl;

public class EmployeeController {

	public EmployeeController() {
		EmployeeService employeeService = new EmployeeServiceImpl();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Employee Management");
			System.out.println("1.Add");
			System.out.println("2.Persist");
			System.out.println("3.Update");
			System.out.println("4.Delete");
			System.out.println("5.Get");
			System.out.println("6.Exit");
			System.out.println("Enter choice: ");
			int ch = sc.nextInt();
			switch (ch) {
			case 1:
				employeeService.saveEmployee(new Employee("Brije sh Nishad", "bnlv 1212@gmail.com", 293, "HCLdfTech"));
				System.out.println("Added successfully");
				break;
			case 2:
				Employee emp = new Employee();
				emp.setAge(25);
				emp.setEmailId("a.b@gmail.com");
				emp.setName("ABC");
				emp.setCompany("HCL");
				employeeService.persistEmployee(emp);

				System.out.println("Persisted successfully");
				break;
			case 3:
				Employee toUpdate = new Employee();
				toUpdate.setAge(59);
				toUpdate.setEmailId("rst@gmail.com");
				toUpdate.setName("Rohan");
				toUpdate.setCompany("FCL");
				employeeService.updateEmployee(toUpdate, 10);
				System.out.println("Updated successfully");
				break;
			case 4:
				employeeService.deleteEmployee(7);
				System.out.println("Deleted successfully");

				break;
			case 5:
				Employee empl = employeeService.getEmployee(10);
				System.out.println(empl);
				System.out.println("Got successfully");
				break;

			default:
				System.out.println("Enter Correct input");
			}
		}
	}
}
