package com.cetpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cetpa.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>
{
	List<Employee> findByDeptId(int deptId);
}
