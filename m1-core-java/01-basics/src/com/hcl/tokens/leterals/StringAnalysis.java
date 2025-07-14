/*
 * 4. String Literal – Palindrome & Frequency Analysis
Question:
Write a program that checks if a string literal is a palindrome and also performs frequency analysis of each character in the string.

Challenge: Ignore case and non-alphabetic characters during analysis.
 */
package com.hcl.tokens.leterals;
import java.util.HashMap;

public class StringAnalysis {
    public static void main(String[] args) {
        String input = "Madam, in Eden, I'm Adam";
        String cleaned = input.replaceAll("[^a-zA-Z]", "").toLowerCase();

        // Palindrome check
        String reversed = new StringBuilder(cleaned).reverse().toString();
        System.out.println("Is palindrome? " + cleaned.equals(reversed));

        // Frequency analysis
        HashMap<Character, Integer> freq = new HashMap<>();
        for (char c : cleaned.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        System.out.println("Character Frequencies:");
        for (char c : freq.keySet()) {
            System.out.println(c + ": " + freq.get(c));
        }
    }
}
