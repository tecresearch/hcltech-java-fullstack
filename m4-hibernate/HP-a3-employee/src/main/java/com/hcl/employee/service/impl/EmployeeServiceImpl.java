package com.hcl.employee.service.impl;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hcl.employee.model.Employee;
import com.hcl.employee.repository.EmployeeRepository;
import com.hcl.employee.repository.impl.EmployeeRepositoryImpl;
import com.hcl.employee.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	EmployeeServiceImpl() {
		this.employeeRepository = new EmployeeRepositoryImpl();
	}

	@Override
	public void saveEmployee(Employee employee) {
		employeeRepository.save(employee);

	}

	@Override
	public void persistEmployee(Employee employee) {
		employeeRepository.persist(employee);

	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeRepository.update(employee);

	}

	@Override
	public void deleteEmployee(Employee employee) {
		employeeRepository.delete(employee);

	}

	@Override
	public Employee getEmployee( int id) {
		return employeeRepository.get( id);
	}

}
