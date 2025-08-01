package com.cetpa.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cetpa.entity.User;
import com.cetpa.entity.UserRole;

public class UserDetsailsImpl implements UserDetails 
{
	private static final long serialVersionUID = 1L;
	
	private User user;
	public UserDetsailsImpl(User user) 
	{
		this.user = user;
	}
	public Collection<? extends GrantedAuthority> getAuthorities() 
	{
		System.out.println("getAuthoroties method invoked...");
		Set<UserRole> roleSet=user.getUserRoles();
		//Create set collection of GrantedAuthority interface.
		//In the object of GrantedAuthority interface keep role of the user as ROLE_admin
		Set<SimpleGrantedAuthority> roles=new HashSet<>();
		for(UserRole role:roleSet)
		{
			String roleMap="ROLE_"+role.getRole();
			roles.add(new SimpleGrantedAuthority(roleMap));
		}
		//By using lambda expression
		//Set<SimpleGrantedAuthority> roles=roleSet.stream().map((role)->new SimpleGrantedAuthority("ROLE_"+role.getRole())).collect(Collectors.toSet());
		return roles;
	}
	public String getPassword() 
	{
		System.out.println("getPassword method invoked...");
		return user.getUserPassword();
	}
	public String getUsername() 
	{
		System.out.println("getUserName method invoked...");
		return user.getUserName();
	}
}
