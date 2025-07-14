/*
 * Advanced Bit Manipulation Question #2
🔍 Problem:
Find the Two Unique Numbers in an Array Where Every Other Number Appears Twice

📝 Description:
Given an array of integers where every number appears twice except for two unique numbers, write a Java program to find those two numbers using bit manipulation.
 */

package com.hcl.tokens.operators;
public class TwoUniqueNumbers {
    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2, 5}; // Unique numbers are 4 and 5

        // Step 1: XOR all numbers to get xor of the two unique numbers
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        // xor = a ^ b (where a and b are the unique numbers)
        // Step 2: Find a set bit (rightmost set bit) in xor
        int rightmostSetBit = xor & -xor;

        // Step 3: Divide numbers into two groups based on the set bit
        int num1 = 0, num2 = 0;
        for (int num : nums) {
            if ((num & rightmostSetBit) == 0) {
                num1 ^= num; // Group 1
            } else {
                num2 ^= num; // Group 2
            }
        }

        System.out.println("The two unique numbers are: " + num1 + " and " + num2); // Output: 4 and 5
    }
}
