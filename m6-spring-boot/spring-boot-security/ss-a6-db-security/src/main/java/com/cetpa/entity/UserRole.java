package com.cetpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "userrole")
public class UserRole implements Comparable<UserRole>
{
	@Id
	@Column(name="roleid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roleId;
	private String role;
	private String description;
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int compareTo(UserRole role) 
	{
		int c=this.roleId-role.roleId;
		return c;
	}
	
}
