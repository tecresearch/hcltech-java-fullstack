package com.hcl.model;

import jakarta.persistence.Entity;

@Entity
public class NonTeachingStaff extends Staff 
{
	private String area;
	public NonTeachingStaff() {}
	public NonTeachingStaff(int staffid,String name,String phone,String area) 
	{
		super(staffid,name,phone);
		this.area=area;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	
}
