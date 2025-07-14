package com.hcl.tokens.operators;
import java.util.Scanner;

public class ArithmeticOperators {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int a = sc.nextInt();

        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        // Addition
        System.out.println("Addition: " + (a + b)); // Adds a and b

        // Subtraction
        System.out.println("Subtraction: " + (a - b)); // Subtracts b from a

        // Multiplication
        System.out.println("Multiplication: " + (a * b)); // Multiplies a and b

        // Division with zero check
        if (b != 0) {
            System.out.println("Division: " + (a / b)); // Divides a by b
           System.out.println("Modulus: " + (a % b)); // Remainder of a divided by b
        } else {
            System.out.println("Cannot divide by zero.");
        }
    }
}
