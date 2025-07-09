package in.tca.beans;

public class Course {
	private int cid;
	private String name;
	private String duration;
	private int price;
	public int getCid() {
		return cid;
	}
	public void setCid(int i) {
		this.cid = i;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Course [cid=" + cid + ", name=" + name + ", duration=" + duration + ", price=" + price + "]";
	}
	
	
}
