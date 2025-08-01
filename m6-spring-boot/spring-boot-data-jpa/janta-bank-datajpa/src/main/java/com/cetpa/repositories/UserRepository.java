package com.cetpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cetpa.models.User;

public interface UserRepository extends JpaRepository<User,String> 
{
}
