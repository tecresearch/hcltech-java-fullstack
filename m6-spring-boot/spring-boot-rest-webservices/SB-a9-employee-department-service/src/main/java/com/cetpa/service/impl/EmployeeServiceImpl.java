package com.cetpa.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetpa.dto.EmployeeDto;
import com.cetpa.entity.Employee;
import com.cetpa.mapper.EmployeeMapper;
import com.cetpa.repository.DepartmentRepository;
import com.cetpa.repository.EmployeeRepository;
import com.cetpa.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService 
{
	@Autowired private EmployeeRepository employeeRepository;
	@Autowired private DepartmentRepository departmentRepository;
	//@Autowired private EmployeeMapper employeeMapper;
	@Autowired private ModelMapper modelMapper;
	
	public void saveEmployee(Employee employee) 
	{
		employeeRepository.save(employee);
		departmentRepository.updateTotalEmployees(employee.getDepartment().getDeptId(),1);
	}
	/*public Employee getRecord(int eid) 
	{
		return employeeRepository.getEmployeeDetails(eid);
	}*/
	public EmployeeDto getRecord(int eid) 
	{
		Employee employee=employeeRepository.getEmployeeDetails(eid);
		EmployeeDto employeeDto=modelMapper.map(employee,EmployeeDto.class);
		employeeDto.setDeptName(employee.getDepartment().getDeptName());
		return employeeDto;
	}
}
