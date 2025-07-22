package com.hcl.aop;

import org.springframework.stereotype.Component;

@Component
public class Service1 {

	public void addNumber(int a, int b) {
	
		System.out.println(a + b);
		
	}

	public void substractNumber(int a, int b) {

		System.out.println(a - b);

	}

	public void mulNumber(int a, int b) {

		System.out.println(a * b);

	}

}
