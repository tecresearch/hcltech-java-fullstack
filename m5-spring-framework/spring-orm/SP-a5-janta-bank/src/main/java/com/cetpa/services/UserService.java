package com.cetpa.services;

import com.cetpa.models.User;

public interface UserService 
{
	int saveUser(User user);
	User getUser(String userid);
}
