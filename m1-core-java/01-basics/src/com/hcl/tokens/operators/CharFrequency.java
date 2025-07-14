/*
 * 2. Count Frequency of Characters in a String
Question:
Write a Java program to count the frequency of each character in a string using a HashMap.
 */

package com.hcl.tokens.operators;
import java.util.HashMap;

public class CharFrequency {
    public static void main(String[] args) {
        String str = "hello world";
        HashMap<Character, Integer> freqMap = new HashMap<>();

        for (char ch : str.toCharArray()) {
            if (ch != ' ') { // Ignore spaces
                freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
            }
        }

        // Print frequency of each character
        for (char ch : freqMap.keySet()) {
            System.out.println(ch + ": " + freqMap.get(ch));
        }
    }
}
