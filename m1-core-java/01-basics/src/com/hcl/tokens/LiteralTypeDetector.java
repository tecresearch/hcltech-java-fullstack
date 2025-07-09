/*
 * Problem Statement:

Write a Java program that takes a list of string inputs representing different literals and determines their type. The program should classify each literal as one of the following:

Integer Literal
Floating-point Literal
Character Literal
String Literal
Boolean Literal
Invalid Literal
 */
package com.hcl.tokens;
import java.util.*;

public class LiteralTypeDetector {

    public static void main(String[] args) {
        List<String> inputs = Arrays.asList("10", "3.14", "'a'", "\"Hello\"", "true", "xyz");

        for (String literal : inputs) {
            System.out.println(literal + " → " + detectType(literal));
        }
    }

    public static String detectType(String literal) {
        // Check for Boolean
        if (literal.equals("true") || literal.equals("false")) {
            return "Boolean Literal";
        }

        // Check for Integer
        try {
            Integer.parseInt(literal);
            return "Integer Literal";
        } catch (NumberFormatException ignored) {}

        // Check for Floating-point
        try {
            Double.parseDouble(literal);
            if (literal.contains(".")) {
                return "Floating-point Literal";
            }
        } catch (NumberFormatException ignored) {}

        // Check for Character
        if (literal.matches("'[^']'")) {
            return "Character Literal";
        }

        // Check for String
        if (literal.matches("\".*\"")) {
            return "String Literal";
        }

        return "Invalid Literal";
    }
}
