package in.tca.beans;

public class Address {
	
	private String area;
	private String district;
	private String state;
	int pin;
	
	public Address(String area, String district, String state, int pin) {
		super();
		this.area = area;
		this.district = district;
		this.state = state;
		this.pin = pin;
	}

	@Override
	public String toString() {
		return "Address [area=" + area + ", district=" + district + ", state=" + state + ", pin=" + pin + "]";
	}
	
	
	
	
	

}
