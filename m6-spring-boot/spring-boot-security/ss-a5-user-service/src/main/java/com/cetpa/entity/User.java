package com.cetpa.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class User 
{
	@Id
	@Column(name = "username")
	private String userName;
	@Column(name = "password")
	private String userPassword;
	private String name;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "userandrole",joinColumns = @JoinColumn(name="username"),inverseJoinColumns = @JoinColumn(name="roleid"))
	private Set<UserRole> userRoles;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<UserRole> getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
}
