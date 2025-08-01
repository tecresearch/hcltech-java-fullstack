package com.hcl.model;

import jakarta.persistence.Entity;

@Entity
public class TeachingStaff extends Staff 
{
	private String qualification;
	private String subject;
	public TeachingStaff() {}
	public TeachingStaff(int staffid,String name,String phone,String qualification, String subject) 
	{
		super(staffid,name,phone);
		this.qualification = qualification;
		this.subject = subject;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
}
