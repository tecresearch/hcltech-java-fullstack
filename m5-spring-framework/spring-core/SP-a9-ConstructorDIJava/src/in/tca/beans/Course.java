package in.tca.beans;

public class Course {
	private int cid;
	private String name;
	private String duration;
	private int price;
	public Course(int cid, String name, String duration, int price) {
		super();
		this.cid = cid;
		this.name = name;
		this.duration = duration;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Course [cid=" + cid + ", name=" + name + ", duration=" + duration + ", price=" + price + "]";
	}

	
	
}
