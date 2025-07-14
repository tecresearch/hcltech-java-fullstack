package com.hcl.tokens.operators;
public class UnaryOperators {
    public static void main(String[] args) {
        int x = 5;

        // Pre-increment: increments before use
        System.out.println("Pre-increment (++x): " + (++x)); // x becomes 6

        // Post-increment: increments after use
        System.out.println("Post-increment (x++): " + (x++)); // prints 6, then x becomes 7

        // Pre-decrement
        System.out.println("Pre-decrement (--x): " + (--x)); // x becomes 6

        // Post-decrement
        System.out.println("Post-decrement (x--): " + (x--)); // prints 6, then x becomes 5
    }
}
