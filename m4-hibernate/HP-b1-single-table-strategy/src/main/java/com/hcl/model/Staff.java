package com.hcl.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Staff {
	@Id
	private int staffid;
	private String name;
	private String phone;
	public Staff() {
		 
	}
	public Staff(int staffid, String name, String phone) {
		super();
		this.staffid = staffid;
		this.name = name;
		this.phone = phone;
	}
	public int getStaffid() {
		return staffid;
	}
	public void setStaffid(int staffid) {
		this.staffid = staffid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Staff [staffid=" + staffid + ", name=" + name + ", phone=" + phone + "]";
	} 
	
	
}





