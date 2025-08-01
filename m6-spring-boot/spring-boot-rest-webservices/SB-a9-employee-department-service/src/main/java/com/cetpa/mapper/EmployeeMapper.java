package com.cetpa.mapper;

import com.cetpa.dto.EmployeeDto;
import com.cetpa.entity.Employee;

public class EmployeeMapper 
{
	public EmployeeDto mapToDto(Employee employee)
	{
		if(employee==null)
			return null;
		EmployeeDto employeeDto=new EmployeeDto();
		employeeDto.setEmpId(employee.getEmpId());
		employeeDto.setEmpName(employee.getEmpName());
		employeeDto.setEmpSalary(employee.getEmpSalary());
		employeeDto.setDeptName(employee.getDepartment().getDeptName());
		return employeeDto;
	}
}
