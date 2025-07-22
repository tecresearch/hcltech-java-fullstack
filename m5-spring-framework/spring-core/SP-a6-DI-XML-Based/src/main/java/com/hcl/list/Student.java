package com.hcl.list;

import java.util.List;

public class Student {
	private int id;
	private String name;
	private List<Subject> subject;
	public Student(int id, String name, List<Subject> subject) {
		super();
		this.id = id;
		this.name = name;
		this.subject = subject;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", subject=" + subject + "]";
	}
	
	
}

