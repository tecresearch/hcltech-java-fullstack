package com.hcl.tax;

import java.util.Scanner;

public class EmployeeTax {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("Enter ammount:");
			int am = sc.nextInt();
			System.out.println("Enter citizenship:");
			boolean ct = sc.nextBoolean();
			TaxCalculator tax = new TaxCalculator(am, ct);
			float myTax = tax.calculateTax();
			System.out.println("The Tax of employee for the "+am+": " + myTax);
			int netSalary = tax.deductTax(myTax);
			System.out.println("The net salary of the employee: " + netSalary);
			System.out.println("The salary and citizenship eligibility: " + tax.validateSalary(am, tax.isCitizenship()));
		} while (true);

	}

}
