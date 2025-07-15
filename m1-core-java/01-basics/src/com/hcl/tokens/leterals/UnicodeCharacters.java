/*
 * 3. Character Literal – Unicode Manipulation
Question:
Write a program that takes a character literal and prints its Unicode value. Then, generate the next 10 characters in the Unicode sequence and display their values and meanings.

Challenge: Handle special characters and escape sequences properly.
 */
package com.hcl.tokens.leterals;
public class UnicodeCharacters {
    public static void main(String[] args) {
        char ch = 'A';
        System.out.println("Original Character: " + ch + " Unicode: " + (int) ch);

        for (int i = 1; i <26; i++) {
            char nextChar = (char) (ch + i);
            System.out.println("Next Char " + (i-1) + ": " + nextChar + " Unicode: " + (int) nextChar);
        }
    }
}
