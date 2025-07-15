/*
 * 4. Find the First Non-Repeating Character in a String
Question:
Write a Java program to find the first non-repeating character in a string.
 */
package com.hcl.tokens.operators;
import java.util.LinkedHashMap;

public class FirstUniqueChar {
    public static void main(String[] args) {
        String str = "swiss";
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();

        for (char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (char ch : map.keySet()) {
            if (map.get(ch) == 1) {
                System.out.println("First non-repeating character: " + ch); // Output: w
                break;
            }
        }
    }
}
