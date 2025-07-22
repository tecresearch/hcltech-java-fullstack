package com.hcl.constructor;

public class Product {
	private int pid;
	private String name;
	private int  price;
	
	public Product(int pid, String name, int price) {
		super();
		this.pid = pid;
		this.name = name;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", name=" + name + ", price=" + price + "]";
	}
	
	
}
