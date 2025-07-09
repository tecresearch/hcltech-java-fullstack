package in.tca.beans;

public class Address {
	
	private String area;
	private String district;
	private String state;
	int pin;
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	@Override
	public String toString() {
		return "Address [area=" + area + ", district=" + district + ", state=" + state + ", pin=" + pin + "]";
	}
	
	

}
