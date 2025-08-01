package com.cetpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetpa.entity.User;
import com.cetpa.repository.UserRepositiry;

@Service
public class UserService  
{
	@Autowired private UserRepositiry userRepositiry;

	public void saveUser(User user) 
	{
		userRepositiry.save(user);
	}
}
