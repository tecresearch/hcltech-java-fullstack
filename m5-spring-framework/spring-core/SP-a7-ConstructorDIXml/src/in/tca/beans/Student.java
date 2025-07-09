package in.tca.beans;

public class Student {

	private int id;
	private String name;
	private String phone;
	private Address address;
	public Student(int id, String name, String phone, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.address = address;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", phone=" + phone + ", address=" + address + "]";
	}
	
	
	
	
}
