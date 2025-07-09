package in.tca.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Client {

	private String name;
	@Autowired
	@Qualifier("taskId2")
	private Task task;
	@Override
	public String toString() {
		return "Client [name=" + name + ", task=" + task + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	
}
