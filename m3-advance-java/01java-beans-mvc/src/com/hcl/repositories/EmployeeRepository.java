package com.hcl.repositories;
import java.util.List;

import com.hcl.entities.*;
public interface EmployeeRepository {
	
	public boolean save(Employee employee);
	public void update(int empId);
	public Employee findByEmpId(int empId);
	public List<Employee> findAll();
	public boolean deleteByEmpId(int empId);

}
