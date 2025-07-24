package com.hcl.setup;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.hcl.setup.config.SpringConfig;

public class App {
	public static void main(String[] args) {
	    ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
	    NamedParameterJdbcTemplate namedParameterJdbcTemplate = context.getBean(NamedParameterJdbcTemplate.class);
	    Scanner scanner = new Scanner(System.in);
	    while (true) {
	        System.out.println("Menu:");
	        System.out.println("1. Insert Employee");
	        System.out.println("2. Update Employee Salary");
	        System.out.println("3. Delete Employee");
	        System.out.println("4. Get All Employees");
	        System.out.println("5. Filter Employees by Salary");
	        System.out.println("6. Get Employee Details");
	        System.out.println("7. Exit");
	        System.out.print("Choose an option: ");

	        int choice = scanner.nextInt();
	        switch (choice) {
	            case 1:
	                System.out.print("Enter ID: ");
	                int id = scanner.nextInt();
	                scanner.nextLine(); // Consume newline
	                System.out.print("Enter Name: ");
	                String name = scanner.nextLine();
	                System.out.print("Enter Email: ");
	                String email = scanner.nextLine();
	                System.out.print("Enter Salary: ");
	                int salary = scanner.nextInt();
	                insertEmployee(namedParameterJdbcTemplate, id, name, email, salary);
	                break;
	            case 2:
	                System.out.print("Enter ID to update: ");
	                int updateId = scanner.nextInt();
	                System.out.print("Enter new Salary: ");
	                int newSalary = scanner.nextInt();
	                updateEmployeeSalary(namedParameterJdbcTemplate, updateId, newSalary);
	                break;
	            case 3:
	                System.out.print("Enter ID to delete: ");
	                int deleteId = scanner.nextInt();
	                deleteEmployee(namedParameterJdbcTemplate, deleteId);
	                break;
	            case 4:
	                List<Map<String, Object>> employees = getAllEmployees(namedParameterJdbcTemplate);
	                System.out.println("Employees: " + employees);
	                break;
	            case 5:
	                System.out.print("Enter Salary to filter: ");
	                int filterSalary = scanner.nextInt();
	                List<Map<String, Object>> filteredEmployees = getEmployeesBySalary(namedParameterJdbcTemplate, filterSalary);
	                System.out.println("Filtered Employees: " + filteredEmployees);
	                break;
	            case 6:
	            	 // Create tables if they do not exist
	        	    createTables(namedParameterJdbcTemplate);
	                List<Map<String, Object>> employeeDetails = getEmployeeDetails(namedParameterJdbcTemplate);
	                System.out.println("Employee Details: " + employeeDetails);
	                break;
	            case 7:
	                System.out.println("Exiting...");
	                scanner.close();
	                return;
	            default:
	                System.out.println("Invalid option. Please try again.");
	        }
	    }
	}

		private static void dropColunm(NamedParameterJdbcTemplate jdbcTemplate) {
			String dropC="ALTER TABLE employees DROP COLUMN department_id";
			jdbcTemplate.getJdbcTemplate().execute(dropC);
		}
	private static void createTables(NamedParameterJdbcTemplate jdbcTemplate) {
	    String createEmployeesTable = "CREATE TABLE IF NOT EXISTS employees (" +
	            "id INT PRIMARY KEY, " +
	            "name VARCHAR(100), " +
	            "email VARCHAR(100), " +
	            "salary INT, " +
	            "department_id INT)";
	    String alterEmployeesTable = "ALTER TABLE employees ADD COLUMN department_id INT";
	   
	    String createDepartmentsTable = "CREATE TABLE IF NOT EXISTS departments (" +
	            "id INT PRIMARY KEY, " +
	            "department_name VARCHAR(100))";

	    jdbcTemplate.getJdbcTemplate().execute(createDepartmentsTable);
	    jdbcTemplate.getJdbcTemplate().execute(createEmployeesTable);
	    jdbcTemplate.getJdbcTemplate().execute(alterEmployeesTable);
	    // Insert data into departments table
	    String insertDepartment = "INSERT INTO departments (id, department_name) VALUES (:id, :department_name)";
	    Map<String, Object> departmentParams = new HashMap<>();
	    departmentParams.put("id", 1);
	    departmentParams.put("department_name", "Engineering");
	    jdbcTemplate.update(insertDepartment, departmentParams);

	    // Insert data into employees table
	    String insertEmployee = "INSERT INTO employees (id, name, email, salary, department_id) VALUES (:id, :name, :email, :salary, :department_id)";
	    Map<String, Object> employeeParams = new HashMap<>();
	    employeeParams.put("id", 1);
	    employeeParams.put("name", "John Doe");
	    employeeParams.put("email", "john.doe@example.com");
	    employeeParams.put("salary", 60000);
	    employeeParams.put("department_id", 1);
	    jdbcTemplate.update(insertEmployee, employeeParams);
	}
    private static void insertEmployee(NamedParameterJdbcTemplate jdbcTemplate, int id, String name, String email, int salary) {
        String insertQuery = "INSERT INTO employees (id, name, email, salary) VALUES (:id, :name, :email, :salary)";
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        params.put("name", name);
        params.put("email", email);
        params.put("salary", salary);

        int count = jdbcTemplate.update(insertQuery, params);
        System.out.println(count > 0 ? "Inserted" : "Failed to insert");
    }

    private static void updateEmployeeSalary(NamedParameterJdbcTemplate jdbcTemplate, int id, int newSalary) {
        String updateQuery = "UPDATE employees SET salary = :salary WHERE id = :id";
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        params.put("salary", newSalary);

        int count = jdbcTemplate.update(updateQuery, params);
        System.out.println(count > 0 ? "Updated salary" : "Failed to update salary");
    }

    private static void deleteEmployee(NamedParameterJdbcTemplate jdbcTemplate, int id) {
        String deleteQuery = "DELETE FROM employees WHERE id = :id";
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);

        int count = jdbcTemplate.update(deleteQuery, params);
        System.out.println(count > 0 ? "Deleted employee" : "Failed to delete employee");
    }

    private static List<Map<String, Object>> getAllEmployees(NamedParameterJdbcTemplate jdbcTemplate) {
        String selectQuery = "SELECT * FROM employees";
        return jdbcTemplate.queryForList(selectQuery, new HashMap<>());
        
    }
    
    private static List<Map<String, Object>> getEmployeesBySalary(NamedParameterJdbcTemplate jdbcTemplate, int salary) {
        String selectQuery = "SELECT * FROM employees WHERE salary > :salary";
        Map<String, Object> params = new HashMap<>();
        params.put("salary", salary);
        return jdbcTemplate.queryForList(selectQuery, params);
    }

    private static List<Map<String, Object>> getEmployeeDetails(NamedParameterJdbcTemplate jdbcTemplate) {
        String joinQuery = "SELECT e.id, e.name, d.department_name FROM employees e JOIN departments d ON e.department_id = d.id";
        return jdbcTemplate.queryForList(joinQuery, new HashMap<>());
    }
}