package com.hcl.polymorphism;
 class Parent {
	Parent(){
		System.out.println("Parent constructor called");
	}
}

public class Child extends Parent{
	int num;
	Child(){
		num=100;
	}
	Child(int n){
		this.num=n;
	}
	Child(int n,String str){
		num=100;
		System.out.println("Str is "+ str);
	}
	void Child() {
		num=200;
	}
	
	public static void main(String[] args) {
		Child c=new Child();
		System.out.println("num is "+ c.num);
		c.Child();
		System.out.println("num is "+ c.num);
		Child c1=new Child(1000);
		System.out.println("num is "+ c1.num);
	}
}
