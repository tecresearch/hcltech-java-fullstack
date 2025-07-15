/*
 * 1. Reverse a Number Without Using String
Question:
Write a Java program to reverse an integer number without converting it to a string.
 */

package com.hcl.tokens.operators;
public class ReverseNumber {
    public static void main(String[] args) {
        int number = 12345;
        int reversed = 0;

        // Extract digits and build reversed number
        while (number != 0) {
            int digit = number % 10; // Get last digit
            reversed = reversed * 10 + digit; // Append digit
            number /= 10; // Remove last digit
        }

        System.out.println("Reversed number: " + reversed); // Output: 54321
    }
}
