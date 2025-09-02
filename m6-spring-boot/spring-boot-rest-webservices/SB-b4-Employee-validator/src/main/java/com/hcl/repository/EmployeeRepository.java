package com.hcl.repository;

import org.springframework.data.repository.CrudRepository;

import com.hcl.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{

}
