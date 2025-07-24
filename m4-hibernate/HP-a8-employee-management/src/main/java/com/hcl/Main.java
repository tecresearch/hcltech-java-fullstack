package com.hcl;

import com.hcl.model.Employee;
import com.hcl.repository.EmployeeRepository;

public class Main {
	public static void main(String[] args) {
		EmployeeRepository employeeRepository = new EmployeeRepository();
		Employee employee = new Employee("Brijesh ","Nishad","9506563150","CS-IoT","Bnlv1212@gmail.com","132435");
		employeeRepository.saveEmployee(employee);
		employeeRepository.getAllEmployees();
		employeeRepository.getEmployee(2);
		employeeRepository.deleteEmployee(2);
		employeeRepository.updateEmployee(new Employee("Kishan ","Nishad","9506563150","CS-IoT","Bnlv1212@gmail.com","132435"), 4);
		employeeRepository.getEmployee(8);
	}
}
