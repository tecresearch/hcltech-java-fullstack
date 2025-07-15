/*
 * Find the Unique Number in an Array Where Every Other Number Appears Thrice

📝 Description:
Given an array of integers where every number appears three times except for one unique number, write a Java program to find that unique number using bit manipulation only (no extra space like HashMaps).
 */
package com.hcl.tokens.operators;
public class UniqueNumberThrice {
    public static void main(String[] args) {
        int[] nums = {6, 1, 3, 3, 3, 6, 6, 1, 1, 9}; // 9 is the unique number

        int ones = 0, twos = 0;

        for (int num : nums) {
            // First appearance: add to ones
            // Second appearance: add to twos
            // Third appearance: remove from ones and twos

            ones = (ones ^ num) & ~twos;
            twos = (twos ^ num) & ~ones;
        }

        System.out.println("Unique number is: " + ones); // Output: 9
    }
}
