package com.hcl.aop.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.aop.rest.model.Task;

public interface TaskRepository extends JpaRepository<Task, Integer>{

}
