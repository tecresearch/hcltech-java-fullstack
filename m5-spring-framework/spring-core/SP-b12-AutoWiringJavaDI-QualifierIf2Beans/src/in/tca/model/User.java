package in.tca.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class User {
	
	private int uid;
	private String name;
	private String username;
	private String email;
	private String password;
	
	@Autowired
//	@Qualifier("taskId2")
	@Qualifier("taskId1")
	private Task task;
	@Autowired
	private Client client;
	
	@Override
	public String toString() {
		return "User [uid=" + uid + ", name=" + name + ", username=" + username + ", email=" + email + ", password="
				+ password + ", task=" + task + ", client=" + client + "]";
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
