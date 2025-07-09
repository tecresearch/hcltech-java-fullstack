package com.hcl.calculator;

public class Calculator {
	
	public int addition(int num1, int num2) {
		return num1+num2;
	}
	public int substraction(int num1, int num2) {
		return num1-num2;
	}
	public int multiply(int num1, int num2) {
		return num1-num2;
	}
	public void printSmaller(int n1,int n2) {
		if(n1>n2) {
			System.out.println(n2+" is smaller than "+n2);
		}else {
			System.out.println(n1+" is greater than "+n2);
		}
	}

}
