package com.cetpa.service;

import org.springframework.stereotype.Service;

import com.cetpa.entity.UserRole;
import com.cetpa.repository.RoleRepository;

@Service
public class RoleService 
{
	private RoleRepository roleRepository;
	public RoleService(RoleRepository roleRepository) 
	{
		this.roleRepository = roleRepository;
	}
	public void saveRole(UserRole userRole) 
	{
		roleRepository.save(userRole);
	}
	
}
