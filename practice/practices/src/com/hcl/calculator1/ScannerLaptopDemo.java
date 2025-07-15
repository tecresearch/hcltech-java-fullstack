package com.hcl.calculator1;

import java.util.Scanner;

public class ScannerLaptopDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Calculator c=new Calculator();
		int option;
		do {
			System.out.println("1.add");
			System.out.println("2.substract");
			System.out.println("3.multiply");
			System.out.println("Enter your choise:");
			option=sc.nextInt();
			switch(option) {
			case 1:
				System.out.println("Enter first number: ");
				int a=sc.nextInt();
				System.out.println("Enter second number: ");
				int b=sc.nextInt();
				System.out.println(c.addition(a, b));
				break;
			case 2:
				System.out.println("Enter first number: ");
				int a2=sc.nextInt();
				System.out.println("Enter second number: ");
				int b2=sc.nextInt();

				System.out.println(c.substraction(a2, b2));
				break;
			case 3:
				System.out.println("Enter first number: ");
				int a1=sc.nextInt();
				System.out.println("Enter second number: ");
				int b1=sc.nextInt();

				System.out.println(c.multiply(a1, b1));
				break;
			default:
				System.out.println("Invalid input");
			}
			
			
		}while(option!=4);
			 
	}

}
