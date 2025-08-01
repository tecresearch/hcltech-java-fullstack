package com.cetpa.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cetpa.entity.User;
import com.cetpa.repository.UserRepositiry;

@Service
public class UserDetailsServiceImpl implements UserDetailsService 
{
	@Autowired UserRepositiry userRepositiry; 	
	//This method will be invoked by security framework on submission of login form
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		System.out.println("Load user by username method of UserDetailsService invoked...");
		User user=userRepositiry.findById(username).orElse(null);
		if(user==null)
		{
			throw new UsernameNotFoundException("User with username "+username+" not found");
		}
		return new UserDetsailsImpl(user);
	}
}
