/*
 * 2. Floating-Point Literal
Question: Write a program that calculates the area of a circle using a float and a double literal.
 */
package com.hcl.tokens.leterals;
public class FloatingPointLiteralExample {
    public static void main(String[] args) {
        float radius = 7.5f;         // Float literal
        double pi = 3.14159;         // Double literal

        double area = pi * radius * radius;
        System.out.println("Area of the circle: " + area);
    }
}
