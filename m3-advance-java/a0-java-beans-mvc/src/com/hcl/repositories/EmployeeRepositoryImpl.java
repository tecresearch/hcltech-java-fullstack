package com.hcl.repositories;

import java.util.ArrayList;
import java.util.List;

import com.hcl.entities.Employee;

public class EmployeeRepositoryImpl implements EmployeeRepository{
	 ArrayList<Employee> list=new ArrayList<Employee>();
	@Override
	public boolean save(Employee employee) {
		 list.add(employee);
		 System.out.println(list);
		 return true;

	}

	@Override
	public List<Employee> findAll() {
		return list;
	}
	@Override
	public Employee findByEmpId(int empId) {
		for(Employee emp:list) {
			if(emp.getEmpId()==empId) {
				return emp;
			}
		}
		return null;
	}

	
	@Override
	public void update(int empId) {
		// TODO Auto-generated method stub
		
	}

	


	@Override
	public boolean deleteByEmpId(int empId) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
