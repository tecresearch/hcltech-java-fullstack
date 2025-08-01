package com.cetpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cetpa.entity.User;

public interface UserRepositiry extends JpaRepository<User,String> 
{
}
