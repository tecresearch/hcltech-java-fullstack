
/*
 * 6. Null Literal – Safe Object Handling
Question:
Write a program that safely handles null literals in a list of strings. If a string is null, replace it with "Unknown" and count how many nulls were replaced.

Challenge: Use Java Streams to perform the operation efficiently.
 */
package com.hcl.tokens.leterals;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NullHandling {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", null, "Bob", null, "Charlie");

        long nullCount = names.stream().filter(n -> n == null).count();
        List<String> safeList = names.stream()
                                     .map(n -> n == null ? "Unknown" : n)
                                     .collect(Collectors.toList());

        System.out.println("Replaced nulls: " + nullCount);
        System.out.println("Updated List: " + safeList);
    }
}
