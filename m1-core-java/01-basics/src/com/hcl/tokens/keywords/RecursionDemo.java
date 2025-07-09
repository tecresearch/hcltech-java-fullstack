/*
 * 🔑 Keywords Used:
public, class, static, int, return, if
This example is a classic in competitive programming and helps build understanding of recursion, base cases, and method calls.
 */
package com.hcl.tokens.keywords;
public class RecursionDemo {

    // Recursive method to calculate factorial
    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1; // base case
        }
        return n * factorial(n - 1); // recursive call
    }

    public static void main(String[] args) {
        int num = 5;
        System.out.println("Factorial of " + num + " is: " + factorial(num));
    }
}
