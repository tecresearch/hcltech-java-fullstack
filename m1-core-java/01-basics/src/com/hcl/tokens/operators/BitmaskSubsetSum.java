/*
 * Subset Sum Problem Using Bitmasking

📝 Description:
Given an array of integers and a target sum, find all subsets whose sum equals the target using bitmasking.
 */

package com.hcl.tokens.operators;
import java.util.*;

public class BitmaskSubsetSum {
    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 7};
        int target = 10;

        int n = nums.length;

        // Total number of subsets = 2^n
        for (int mask = 0; mask < (1 << n); mask++) {
            List<Integer> subset = new ArrayList<>();
            int sum = 0;

            // Check each bit in the mask
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    subset.add(nums[i]); // Include nums[i] in subset
                    sum += nums[i];      // Add to sum
                }
            }

            // If subset sum equals target, print it
            if (sum == target) {
                System.out.println(subset); // Output: [3, 7], [2, 3, 5]
            }
        }
    }
}
