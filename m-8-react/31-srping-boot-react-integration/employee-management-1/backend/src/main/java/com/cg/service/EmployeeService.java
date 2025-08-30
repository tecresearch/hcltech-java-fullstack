package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.cg.bean.Employee;
import com.cg.dao.IEmployeeRepo;
import com.cg.dto.EmployeeDto;
import com.cg.exception.EmployeeNotFoundException;

@Service
public class EmployeeService implements IEmployeeService {
	@Autowired
	private IEmployeeRepo repo;

	public EmployeeDto createEmployee(EmployeeDto e) {
		Employee emp = new Employee();
		emp.setEmpid(e.getEmpid());
		emp.setName(e.getName());
		emp.setEmail(e.getEmail());
		emp.setDob(e.getDob());
		emp.setSalary(e.getSalary());
		Employee saveEmp = repo.saveAndFlush(emp);
		e.setEmpid(saveEmp.getEmpid());
		return e;
	}

	@Override
	public List<Employee> getAllEmployee() {
		return repo.findAll();
	}

	@Override
	public EmployeeDto getEmployeeByID(int empid) throws EmployeeNotFoundException {
		return repo.findById(empid)
				.map(e -> new EmployeeDto(e.getEmpid(), e.getName(), e.getDob(), e.getSalary(), e.getEmail()))
				.orElseThrow(() -> new EmployeeNotFoundException("Employee with " + empid + " not Found"));

	}
	@Override
	public String removeEmployee(int empid) {
		Optional<Employee> op = repo.findById(empid);
		if (op.isPresent()) {
			repo.delete(op.get());
			return "Employee Deleted";
		} else {
			return "Employee Not Found";
		}

	}

	@Override
	public void updateEmployee(EmployeeDto e)  {
		Employee emp=new Employee(e.getEmpid(),e.getName(), e.getDob(), e.getSalary(), e.getEmail());  //convert EmployeeDTO to Employee
		Optional<Employee> op = repo.findById(e.getEmpid());
		if (op.isPresent())
			repo.saveAndFlush(emp);

	}

	@Override
	public List<Employee> getEmployeeByNameLike(String name) {

		return repo.nameStartsWith(name);
	}
}
