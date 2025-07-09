package in.tca.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("student")
public class Student {
	@Value("21002431")
	private int id;
	@Value("Brijesh Nishad")
	private String name;
	@Value("B.Tech")
	private String course;
	@Value("CSE-IoT")
	private String branch; 
	@Value("#{address}")  //Inject the Address bean using SpEL 
//	@Autowired //or use the auto wiring with @AutoWired
	private Address address;
	
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", course=" + course + ", branch=" + branch + "address="+ address+"]";
	}
	
	
}
