package com.cetpa.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cetpa.model.Employee;


@FeignClient(url="http://localhost:8082/employee",value = "Employee-Client")
public interface EmployeeClient 
{
	@GetMapping("/department/{deptId}")
	List<Employee> getEmployeeListByDeptId(@PathVariable int deptId);
}
