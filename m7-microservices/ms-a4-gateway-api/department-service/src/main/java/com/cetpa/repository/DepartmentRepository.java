package com.cetpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cetpa.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department,Integer>
{
}
