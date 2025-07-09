package in.tca.model;

import org.springframework.beans.factory.annotation.Autowired;

public class User {
	
	private int uid;
	private String name;
	private String username;
	private String email;
	private String password;
	private Task task;
	@Override
	public String toString() {
		return "User [uid=" + uid + ", name=" + name + ", username=" + username + ", email=" + email + ", password="
				+ password + ", task=" + task + "]";
	}
	public User(int uid, String name, String username, String email, String password, Task task) {
		super();
		this.uid = uid;
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.task = task;
	}

	

}
