/*
 * 5. Boolean Literal
Question: Write a program that checks if a number is positive using a boolean literal.
 */

package com.hcl.tokens.leterals;
public class BooleanLiteralExample {
    public static void main(String[] args) {
        int number = 10;
        boolean isPositive = number > 0;  // Boolean literal result

        if (isPositive) {
            System.out.println("The number is positive.");
        } else {
            System.out.println("The number is not positive.");
        }
    }
}
