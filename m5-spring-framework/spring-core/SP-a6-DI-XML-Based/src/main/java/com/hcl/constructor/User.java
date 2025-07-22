package com.hcl.constructor;

public class User {
	private int uid;
	private String name;
	private Product product;
	public User(int uid, String name, Product product) {
		super();
		this.uid = uid;
		this.name = name;
		this.product = product;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", name=" + name + ", product=" + product + "]";
	}
	
	
}
