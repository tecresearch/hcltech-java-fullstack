/*
 * Problem Statement:

Write a Java program that takes a small snippet of Java code as input (as a string) and performs the following:

Tokenizes the input code.
Classifies each token into one of the following categories:
Keyword
Identifier
Literal
Operator
Separator
Comment
Displays the tokens along with their classification.

 */

package com.hcl.tokens;

	import java.util.*;
	import java.util.regex.*;

	public class TokenClassifier {

	    // List of Java keywords
	    static Set<String> keywords = new HashSet<>(Arrays.asList(
	        "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class",
	        "const", "continue", "default", "do", "double", "else", "enum", "extends", "final",
	        "finally", "float", "for", "goto", "if", "implements", "import", "instanceof", "int",
	        "interface", "long", "native", "new", "package", "private", "protected", "public",
	        "return", "short", "static", "strictfp", "super", "switch", "synchronized", "this",
	        "throw", "throws", "transient", "try", "void", "volatile", "while", "true", "false", "null"
	    ));

	    // List of operators
	    static Set<String> operators = new HashSet<>(Arrays.asList(
	        "+", "-", "*", "/", "%", "=", "==", "!=", "<", ">", "<=", ">=", "&&", "||", "!", "++", "--"
	    ));

	    // List of separators
	    static Set<String> separators = new HashSet<>(Arrays.asList(
	        "(", ")", "{", "}", "[", "]", ";", ",", ".", ":"
	    ));

	    public static void main(String[] args) {
	        String code = "int number = 10; // declare a variable";

	        // Remove comments first
	        String commentPattern = "//.*|/\\*[\\s\\S]*?\\*/";
	        Pattern pattern = Pattern.compile(commentPattern);
	        Matcher matcher = pattern.matcher(code);

	        while (matcher.find()) {
	            System.out.println("Token: " + matcher.group() + " → Comment");
	            code = code.replace(matcher.group(), ""); // Remove comment from code
	        }

	        // Split remaining code into tokens
	        String[] tokens = code.split("\\s+|(?=[{}();,])|(?<=[{}();,])");

	        for (String token : tokens) {
	            token = token.trim();
	            if (token.isEmpty()) continue;

	            if (keywords.contains(token)) {
	                System.out.println("Token: " + token + " → Keyword");
	            } else if (operators.contains(token)) {
	                System.out.println("Token: " + token + " → Operator");
	            } else if (separators.contains(token)) {
	                System.out.println("Token: " + token + " → Separator");
	            } else if (token.matches("\\d+")) {
	                System.out.println("Token: " + token + " → Literal (Integer)");
	            } else if (token.matches("\".*\"") || token.matches("'.'")) {
	                System.out.println("Token: " + token + " → Literal (String/Char)");
	            } else {
	                System.out.println("Token: " + token + " → Identifier");
	            }
	        }
	    }
	}

