/*
 * 2. Floating-Point Literal – Precision Comparison
Question:
Write a program that compares the precision of float and double literals by performing a series of mathematical operations (e.g., division, square root, exponentiation) and shows the difference in results.

Challenge: Use BigDecimal to show how floating-point literals can lead to precision errors.
 */
package com.hcl.tokens.leterals;
import java.math.BigDecimal;

public class FloatingPointPrecision {
    public static void main(String[] args) {
        float f = 1.0f / 3.0f;
        double d = 1.0 / 3.0;
        BigDecimal bd = new BigDecimal("1.0").divide(new BigDecimal("3.0"), 20, BigDecimal.ROUND_HALF_UP);

        System.out.println("Float result: " + f);
        System.out.println("Double result: " + d);
        System.out.println("BigDecimal result: " + bd);
        System.out.format("BigDecimal result: %.2f ", bd);
    }
}
