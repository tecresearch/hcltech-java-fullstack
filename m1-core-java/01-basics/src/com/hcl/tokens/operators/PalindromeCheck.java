/*
 *  3. Check if a Number is a Palindrome
Question:
Write a Java program to check if a number is a palindrome (reads the same forward and backward).
 */

package com.hcl.tokens.operators;
public class PalindromeCheck {
    public static void main(String[] args) {
        int num = 1221;
        int original = num;
        int reversed = 0;

        while (num != 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
        }

        if (original == reversed) {
            System.out.println(original + " is a palindrome.");
        } else {
            System.out.println(original + " is not a palindrome.");
        }
    }
}
