package in.tca.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


public class User {

	private int id;
	
	private String username;
	
	private String password;

	private String email;
	
	private Course course;
	
	
	public User(int id, String username, String password, String email, Course course) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.course = course;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + ", course="
				+ course + "]";
	}
	
	
}
