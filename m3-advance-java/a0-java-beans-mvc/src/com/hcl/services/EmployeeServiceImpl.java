package com.hcl.services;

import java.util.List;

import com.hcl.entities.Employee;
import com.hcl.repositories.EmployeeRepository;
import com.hcl.repositories.EmployeeRepositoryImpl;

public class EmployeeServiceImpl implements EmployeeService{
   
	private EmployeeRepository employeeRepository=new EmployeeRepositoryImpl();
	
	public EmployeeServiceImpl(){
		
	}
	public EmployeeServiceImpl(EmployeeRepository employeeRepository){
		this.employeeRepository=employeeRepository;
	}
	

	@Override
	public boolean addEmployee(Employee employee) {
		
		boolean status = employeeRepository.save(employee);
		return status;
		
	}

	@Override
	public void updateEmployeeByEmpId(int empId) {
		
		
	}

	@Override
	public Employee getEmployeeByEmpId(int id) {
      		
		return employeeRepository.findByEmpId(id);
	}

	@Override
	public List<Employee> getEmployees() {
		List<Employee> employeeList=employeeRepository.findAll();
		return employeeList;
	}

	@Override
	public boolean deleteEmployeeByEmpId(int empId) {
		// TODO Auto-generated method stub
		return false;
	}

}
