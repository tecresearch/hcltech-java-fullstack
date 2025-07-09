package com.hcl.exception.custom_exception_age;

public class Person {
	private String name;
	private int age;
	private int percentage;
	public  void setAge(int a)  {
		
				this.age=a;	
	}
	
	public int getAge() {
		return this.age;
	}

	public void setPercentage(int p) throws PercentageException{	
		
			this.percentage=p;

	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPercentage() {
		return percentage;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", percentage=" + percentage + "]";
	}

	

	
	

}
