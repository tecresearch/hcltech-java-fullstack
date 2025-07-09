package in.tca.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component  // This registers the Address bean with the name "address"
public class Address {
	@Value("Varanasi")
	private String area;
	@Value("Uttar Pradesh")
	private String state;
	
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Address [area=" + area + ", state=" + state + "]";
	}
	
	

}
