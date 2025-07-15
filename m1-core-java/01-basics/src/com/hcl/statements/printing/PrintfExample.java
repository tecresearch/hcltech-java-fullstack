/*
 * ✅ Purpose:
Same as printf() — just a different method name.

🔍 How it works:
Internally calls printf().
Useful if you prefer the term "format" over "printf".
 */

package com.hcl.statements.printing;
public class PrintfExample {
    public static void main(String[] args) {
        String name = "Alice";
        int age = 30;
        double score = 95.6789;

        System.out.printf("Name: %s, Age: %d, Score: %.2f", name, age, score);
    }
}
