package com.cetpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cetpa.entity.UserRole;

public interface RoleRepository extends JpaRepository<UserRole,Integer> 
{
}
