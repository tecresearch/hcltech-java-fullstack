/*
 * 3. Character Literal
Question: Write a program that prints the ASCII value of a character literal.
 */
package com.hcl.tokens.leterals;
public class CharacterLiteralExample {
    public static void main(String[] args) {
        char ch = 'A';              // Character literal
        int ascii = ch;             // Implicit conversion to int
        System.out.println("ASCII value of '" + ch + "' is: " + ascii);
    }
}
