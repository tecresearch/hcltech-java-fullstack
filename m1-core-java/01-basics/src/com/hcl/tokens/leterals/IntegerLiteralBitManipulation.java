/*
 * 1. Integer Literal – Bit Manipulation Challenge
Question:
Write a Java program that takes four integer literals 
(decimal, octal, hexadecimal, binary), performs
 bitwise operations (AND, OR, XOR, NOT),
  and prints the results in all four formats.

Challenge: Convert and display results in decimal,
 octal, hex, and binary formats.
 */

package com.hcl.tokens.leterals;

public class IntegerLiteralBitManipulation {

	public static void main(String[] args) {
		int decimal=42;
		int octal=052; //8^0*2+8^1*5=42
		int hex=0x2A;//10*16^0+2*16^1=42
		int bin=0b101010;//2^1+2^3+2^5=42
		

		int andResult = decimal & octal & hex & bin;
		int orResult = decimal | octal | hex | bin;
		int xorResult = decimal ^ octal ^ hex ^ bin;
		int notResult = ~decimal;

		System.out.println("AND Result: " + Integer.toBinaryString(andResult));
		System.out.println("OR Result: " + Integer.toBinaryString(orResult));
		System.out.println("XOR Result: " + Integer.toBinaryString(xorResult));
		System.out.println("NOT Result: " + Integer.toBinaryString(notResult));
		
		

	}

}
