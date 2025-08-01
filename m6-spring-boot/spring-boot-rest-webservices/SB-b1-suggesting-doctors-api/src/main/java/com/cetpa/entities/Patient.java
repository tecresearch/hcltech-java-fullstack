package com.cetpa.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Patient 
{
	@Id
	@GeneratedValue(generator = "pat_seq")
	@SequenceGenerator(name="pat_seq",initialValue = 1001,allocationSize = 1)
	private int patid;
	@NotNull(message = "Name is required")
	@Pattern(regexp = "^[A-Za-z ]{3,}$", message = "Name must be at least 3 characters long and contain only letters")
	private String name;
	@NotNull(message = "City is required")
	@Size(max = 20,message = "City should be at max 20 characters")
	private String city;
	@Column(unique = true,length = 100)
	@NotNull(message = "Email is required")
	@Pattern(regexp = "^^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$",message = "Email is not valid")
	private String email;
	@NotNull(message = "Phone number is required")
	@Pattern(regexp = "\\d{10}", message = "Phone number must be exactly 10 digits")
	private String phone;
	@NotNull(message = "Symptom is required")
	@Pattern(regexp = "Arthritis|Backpain|Tissue injuries|Dysmenorrhea|Skin infection|Skin burn|Ear pain",message = "Invalid symptom")
	private String symptom;
	
	public int getPatid() {
		return patid;
	}
	public void setPatid(int patid) {
		this.patid = patid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSymptom() {
		return symptom;
	}
	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}
	
}
