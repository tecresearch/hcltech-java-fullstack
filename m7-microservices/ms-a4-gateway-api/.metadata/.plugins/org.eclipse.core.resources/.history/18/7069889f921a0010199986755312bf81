package com.cetpa.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url="http://localhost:8081/department",value = "Department-Client")
public interface DepartmentClient 
{
	@GetMapping("/department/validate/{deptId}")
	Boolean isDepartmentExist(@PathVariable int deptId);
}
