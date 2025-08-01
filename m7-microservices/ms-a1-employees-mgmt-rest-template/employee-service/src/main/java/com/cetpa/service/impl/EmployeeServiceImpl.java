package com.cetpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cetpa.entity.Employee;
import com.cetpa.repository.EmployeeRepository;
import com.cetpa.service.EmployeeService;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService 
{
	@Autowired private EmployeeRepository employeeRepository;
	@Autowired private RestTemplate restTemplate;
	
	@Transactional
	public void saveEmployee(Employee employee) 
	{
		employeeRepository.save(employee);
		int did=employee.getDeptId();
		//HttpEntity<String> header=new HttpEntity<String>("")
		//restTemplate.exchange("http://localhost:8080/department/update/employee-count/"+did,HttpMethod.PUT,null);
		restTemplate.put("http://localhost:8080/department-service/update/employee-count/increase/"+did,null);
	}
	public Employee getRecord(int eid) 
	{
		return employeeRepository.findById(eid).orElse(null);
	}
	@Transactional
	public void deleteById(int eid,int did) 
	{
		employeeRepository.deleteById(eid);
		restTemplate.put("http://localhost:8080/department/update/employee-count/decrease/"+did,null);
	}
	@Transactional
	public void updateDepartmentById(int newDid,Employee employee) 
	{
		int oldDid=employee.getDeptId();
		employee.setDeptId(newDid);
		employeeRepository.save(employee);
		System.out.println("Employee updated...");
		restTemplate.put("http://localhost:8080/department/update/employee-count?oldDid="+oldDid+"&newDid="+newDid,null);
	}
}
