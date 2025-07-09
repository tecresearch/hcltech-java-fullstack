/*
 * Problem: Compute the nth Fibonacci number using DP (bottom-up approach).
 * 🔑 Keywords Used:
public, class, static, int, if, for, return
This example shows how to optimize recursive problems using a DP table, which is a key technique in reducing time complexity from exponential to linear.
 */

package com.hcl.tokens.keywords;
public class FibonacciDP {

    public static int fibonacci(int n) {
        if (n <= 1) return n;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        // Bottom-up DP
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("Fibonacci number at position " + n + " is: " + fibonacci(n));
    }
}
