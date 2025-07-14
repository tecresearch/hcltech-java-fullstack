package com.hcl.tokens.operators;
import java.util.Scanner;

public class BitwiseOperators {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter two integers: ");
        int a = sc.nextInt();
        int b = sc.nextInt();

        // Bitwise AND
        System.out.println("a & b: " + (a & b)); // AND operation

        // Bitwise OR
        System.out.println("a | b: " + (a | b)); // OR operation

        // Bitwise XOR
        System.out.println("a ^ b: " + (a ^ b)); // XOR operation

        // Bitwise NOT
        System.out.println("~a: " + (~a)); // NOT operation

        // Left shift
        System.out.println("a << 2: " + (a << 2)); // Shifts bits left by 2

        // Right shift
        System.out.println("a >> 2: " + (a >> 2)); // Shifts bits right by 2

        // Binary representation
        System.out.println("Binary of a: " + Integer.toBinaryString(a));
        System.out.println("Binary of b: " + Integer.toBinaryString(b));
    }
}
