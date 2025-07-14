/*
 * 1. Integer Literal
Question: Write a Java program that calculates 
the sum of a decimal, octal,
 hexadecimal, and binary number.
 */
package com.hcl.tokens.leterals;

public class IntegerLiteralExample {
    public static void main(String[] args) {
        int decimal = 100;       // Decimal
        int octal = 0123;        // Octal (equivalent to 83 in decimal)
        int hex = 0x1A;          // Hexadecimal (equivalent to 26 in decimal)
        int binary = 0b1010;     // Binary (equivalent to 10 in decimal)

        int sum = decimal + octal + hex + binary;
        System.out.println("Sum of literals: " + sum);
    }
}
