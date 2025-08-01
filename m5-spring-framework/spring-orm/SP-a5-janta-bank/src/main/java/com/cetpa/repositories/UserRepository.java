package com.cetpa.repositories;

import com.cetpa.models.User;

public interface UserRepository 
{
	void persistUser(User user);
	User findUserById(String userid);
}
