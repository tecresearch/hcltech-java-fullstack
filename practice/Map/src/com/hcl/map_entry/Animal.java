package com.hcl.map_entry;

public class Animal {
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Animal() {
		 
		// TODO Auto-generated constructor stub
	}
	public Animal(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Animal [name=" + name + ", age=" + age + "]";
	}
	
	
}
