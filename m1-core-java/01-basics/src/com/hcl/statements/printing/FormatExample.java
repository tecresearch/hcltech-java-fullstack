
/*
 * 
 * ✅ Purpose:
Prints formatted output using format specifiers.

🔍 How it works:
%d for integers, %s for strings, %f for floating-point numbers, etc.
You can control decimal places, alignment, padding, etc.
 */
package com.hcl.statements.printing;
public class FormatExample {
    public static void main(String[] args) {
        double pi = Math.PI;
        System.out.format("Value of Pi: %.3f", pi);
    }
}
