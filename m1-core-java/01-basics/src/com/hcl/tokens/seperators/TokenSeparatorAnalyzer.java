/*
 * Java Coding Challenge: Token Separator Analyzer
Problem Statement:

Write a Java program that takes a block of Java code as a string input and analyzes it to count the number of separator tokens used. Specifically, count the occurrences of the following separators:

(, ), {, }, [, ], ;, ,, ., :
✅ Requirements:
Accept a multiline string input (you can hardcode it for simplicity).
Count how many times each separator appears.
Print the result in a readable format.
 */

package com.hcl.tokens.seperators;
import java.util.HashMap;
import java.util.Map;

public class TokenSeparatorAnalyzer {
    public static void main(String[] args) {
        String code = """
            public class Demo {
                public static void main(String[] args) {
                    int[] numbers = {1, 2, 3};
                    for (int num : numbers) {
                        System.out.println(num);
                    }
                }
            }
            """;

        // Define separators to track
        char[] separators = {'(', ')', '{', '}', '[', ']', ';', ',', '.', ':'};
        Map<Character, Integer> separatorCount = new HashMap<>();

        // Initialize map with zero counts
        for (char sep : separators) {
            separatorCount.put(sep, 0);
        }

        // Count occurrences
        for (char ch : code.toCharArray()) {
            if (separatorCount.containsKey(ch)) {
                separatorCount.put(ch, separatorCount.get(ch) + 1);
            }
        }

        // Print results
        System.out.println("Separator Counts:");
        for (char sep : separators) {
            System.out.println(sep + " : " + separatorCount.get(sep));
        }
    }
}
