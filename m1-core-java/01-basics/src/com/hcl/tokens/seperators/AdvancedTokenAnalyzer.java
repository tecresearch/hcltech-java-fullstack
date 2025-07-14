/*
 * 
Problem Statement:
Write a Java program that reads a .java source file and performs the following:

Counts all separator tokens: (, ), {, }, [, ], ;, ,, ., :
Identifies and counts other token types:
Keywords
Identifiers
Literals (numbers, strings, characters)
Operators
Displays a summary report showing:
Total number of tokens
Count of each token type
Count of each separator
✅ Requirements:
Use FileReader or BufferedReader to read the file.
Use regular expressions to identify token types.
Use HashMap or TreeMap to store counts.
Handle comments and string literals properly (don’t count separators inside them).








 * 
 *//*
 * 
Problem Statement:
Write a Java program that reads a .java source file and performs the following:

Counts all separator tokens: (, ), {, }, [, ], ;, ,, ., :
Identifies and counts other token types:
Keywords
Identifiers
Literals (numbers, strings, characters)
Operators
Displays a summary report showing:
Total number of tokens
Count of each token type
Count of each separator
✅ Requirements:
Use FileReader or BufferedReader to read the file.
Use regular expressions to identify token types.
Use HashMap or TreeMap to store counts.
Handle comments and string literals properly (don’t count separators inside them).








 * 
 */
package com.hcl.tokens.seperators;

import java.util.*;

public class AdvancedTokenAnalyzer {

    private static final char[] SEPARATORS = {'(', ')', '{', '}', '[', ']', ';', ',', '.', ':'};
    private static final Set<String> KEYWORDS = Set.of(
        "class", "public", "static", "void", "int", "for", "if", "else", "return"
    );

    public static void main(String[] args) {
        String code = """
            public class Demo {
                public static void main(String[] args) {
                    int x = 10;
                    for (int i = 0; i < x; i++) {
                        System.out.println(i);
                    }
                }
            }
            """;

        Map<Character, Integer> separatorCount = new HashMap<>();
        for (char sep : SEPARATORS) separatorCount.put(sep, 0);

        int keywordCount = 0, identifierCount = 0, literalCount = 0, operatorCount = 0;

        String[] tokens = code.split("\\s+|(?=[{}();,.:\\[\\]])|(?<=[{}();,.:\\[\\]])");

        for (String token : tokens) {
            if (token.isEmpty()) continue;
            if (token.length() == 1 && separatorCount.containsKey(token.charAt(0))) {
                separatorCount.put(token.charAt(0), separatorCount.get(token.charAt(0)) + 1);
            } else if (KEYWORDS.contains(token)) {
                keywordCount++;
            } else if (token.matches("[a-zA-Z_][a-zA-Z0-9_]*")) {
                identifierCount++;
            } else if (token.matches("\\d+")) {
                literalCount++;
            } else if (token.matches("[+\\-*/%=!<>]+")) {
                operatorCount++;
            }
        }

        System.out.println("=== Token Summary ===");
        System.out.println("Keywords: " + keywordCount);
        System.out.println("Identifiers: " + identifierCount);
        System.out.println("Literals: " + literalCount);
        System.out.println("Operators: " + operatorCount);
        System.out.println("Separators:");
        for (char sep : SEPARATORS) {
            System.out.println(sep + " : " + separatorCount.get(sep));
        }
    }
}
