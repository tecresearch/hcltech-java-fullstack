package com.hcl.entity;

public class AuthRequest 
{
	/**
	 * request body :
	 * {
	 * "username":"",
	 * "password":""
	 * }
	 *
	 */
    private String username;
    private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AuthRequest(){}
	public AuthRequest(String username, String password) {
		this.username = username;
		this.password = password;
	}

	@Override
	public String toString() {
		return "AuthRequest{" +
				"username='" + username + '\'' +
				", password='" + password + '\'' +
				'}';
	}
}