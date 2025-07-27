package com.hcl;

import com.hcl.model.Employee;
import com.hcl.repository.EmployeeRepository;

public class Main {
    public static void main(String[] args) {
        EmployeeRepository employeeRepository = new EmployeeRepository();
        try {
            // Create and save a new employee
            Employee employee = new Employee("Brijesh ", "Nishad", "9506563150", "CS-IoT", "Bnlv1212@gmail.com", 32.35);
            employeeRepository.saveEmployee(employee);
            System.out.println("Employee saved successfully.");

            // Retrieve and display all employees
            System.out.println("All Employees:");
            employeeRepository.getAllEmployees();

            // Retrieve a specific employee by ID
            System.out.println("Getting Employee with ID 2:");
            Employee emp = employeeRepository.getEmployee(2);
            if (emp != null) {
                System.out.println(emp);
            } else {
                System.out.println("Employee with ID 2 not found.");
            }

            // Delete an employee by ID
            System.out.println("Deleting Employee with ID 2:");
            employeeRepository.deleteEmployee(2);

            // Update an employee
            System.out.println("Updating Employee with ID 4:");
            employeeRepository.updateEmployee(new Employee("Kishan ", "Nishad", "9506563150", "CS-IoT", "Bnlv1212@gmail.com", 24.4), 4);

            // Retrieve the updated employee
            System.out.println("Getting Employee with ID 4:");
            Employee updatedEmp = employeeRepository.getEmployee(4);
            if (updatedEmp != null) {
                System.out.println(updatedEmp);
            } else {
                System.out.println("Employee with ID 4 not found.");
            }
        } catch (Exception e) {
            e.printStackTrace(); // Log any exceptions that occur
        }
    }
}