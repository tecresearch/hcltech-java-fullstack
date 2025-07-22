package com.hcl.list;

import java.util.List;

public class Subject {
	private int isbn;
	private String name;
	private String duration;
	private List<String> teachers;
	
	
	public List<String> getTeachers() {
		return teachers;
	}
	public void setTeachers(List<String> teachers) {
		this.teachers = teachers;
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
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
	@Override
	public String toString() {
		return "Subject [isbn=" + isbn + ", name=" + name + ", duration=" + duration + ", teachers=" + teachers + "]";
	}
	
	
	
	
	
	
}
