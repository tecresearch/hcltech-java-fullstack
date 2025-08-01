package com.cetpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cetpa.entity.Department;

import jakarta.transaction.Transactional;

public interface DepartmentRepository extends JpaRepository<Department,Integer> 
{
	@Transactional
	@Modifying
	@Query("update Department set totalEmployees=totalEmployees+:arg1 where deptId=:arg2")
	void updateTotalEmployees(@Param("arg2") int deptId,@Param("arg1") int no);
}
