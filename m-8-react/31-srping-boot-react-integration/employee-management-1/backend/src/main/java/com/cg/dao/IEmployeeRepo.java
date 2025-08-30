package com.cg.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.bean.Employee;


public interface IEmployeeRepo extends JpaRepository<Employee, Integer> {
	@Query("select e from Employee e where e.name like :n")
	public List<Employee> nameStartsWith(@Param("n") String name);
}
