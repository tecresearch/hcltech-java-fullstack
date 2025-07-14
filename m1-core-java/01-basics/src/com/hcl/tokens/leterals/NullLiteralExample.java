/*
 * 
6. Null Literal
Question: Write a program that checks if a string is null before printing it.
 */
package com.hcl.tokens.leterals;
public class NullLiteralExample {
    public static void main(String[] args) {
        String text = null;  // Null literal

        if (text == null) {
            System.out.println("The string is null.");
        } else {
            System.out.println("The string is: " + text);
        }
    }
}
