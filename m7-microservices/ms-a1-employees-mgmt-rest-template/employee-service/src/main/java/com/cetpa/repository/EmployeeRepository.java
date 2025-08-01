package com.cetpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cetpa.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> 
{
}
