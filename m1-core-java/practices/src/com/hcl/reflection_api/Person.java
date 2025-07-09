/*
 * The Reflection API in Java is a powerful feature that allows
 *  your program to inspect and manipulate classes, methods, fields,
 *   and constructors at runtime—even if you don’t know their names at 
 *   compile time
 * 
 */
package com.hcl.reflection_api;

public class Person {
	private String name="Brijesh";
	private int age=23;
	private int percentage;
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
	public int getPercentage() {
		return percentage;
	}
	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}
	
	
}
