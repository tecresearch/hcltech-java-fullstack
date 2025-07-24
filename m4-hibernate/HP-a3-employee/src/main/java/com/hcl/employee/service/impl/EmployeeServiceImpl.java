package com.hcl.employee.service.impl;

import com.hcl.employee.model.Employee;
import com.hcl.employee.repository.EmployeeRepository;
import com.hcl.employee.repository.impl.EmployeeRepositoryImpl;
import com.hcl.employee.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	public EmployeeServiceImpl() {
		this.employeeRepository = new EmployeeRepositoryImpl();
	}

	@Override
	public void saveEmployee(Employee employee) {
		employeeRepository.save(employee);

	}

	@Override
	public Employee getEmployee(int id) {
		return employeeRepository.get(id);
	}

	@Override
	public void persistEmployee(Employee employee) {

		employeeRepository.persist(employee);

	}

	@Override
	public void updateEmployee(Employee toUpdate, int id) {

		employeeRepository.update(toUpdate, id);

	}

	@Override
	public void deleteEmployee(int id) {
		employeeRepository.delete(id);

	}

}
