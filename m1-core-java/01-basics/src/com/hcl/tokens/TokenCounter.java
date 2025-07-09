/*
 * Problem Statement:

Write a Java program that takes a snippet of Java code as input (as a string) and counts the number of tokens in it. The program should:

Tokenize the input using spaces and common delimiters.
Count the total number of tokens.
Display each token and its position in the sequence.
 */
package com.hcl.tokens;
import java.util.*;

public class TokenCounter {
    public static void main(String[] args) {
        String code = "int a = 5 + 3;";

        // Regex to split by whitespace and also isolate operators/separators
        String[] rawTokens = code.split("\\s+|(?=[{}();,+*/=])|(?<=[{}();,+*/=])");

        List<String> tokens = new ArrayList<>();
        for (String token : rawTokens) {
            token = token.trim();
            if (!token.isEmpty()) {
                tokens.add(token);
            }
        }

        System.out.println("Total Tokens: " + tokens.size());
        for (int i = 0; i < tokens.size(); i++) {
            System.out.println((i + 1) + ": " + tokens.get(i));
        }
    }
}
