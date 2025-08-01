package com.cetpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cetpa.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> 
{
	@Query("from Employee where empId=:arg")
	Employee getEmployeeDetails(@Param("arg") int eid);
}
