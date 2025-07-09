package com.hcl.tokens;
import java.util.*;
import java.util.regex.*;

public class TokenTypeClassifier1 {

    static Set<String> keywords = new HashSet<>(Arrays.asList(
        "int", "float", "double", "char", "boolean", "if", "else", "while", "for", "return",
        "class", "public", "private", "protected", "static", "void", "new", "true", "false"
    ));

    static Set<String> operators = new HashSet<>(Arrays.asList(
        "+", "-", "*", "/", "%", "=", "==", "!=", "<", ">", "<=", ">=", "&&", "||", "!", "++", "--"
    ));

    static Set<String> separators = new HashSet<>(Arrays.asList(
        "(", ")", "{", "}", "[", "]", ";", ",", "."
    ));

    public static void main(String[] args) {
        String code = "int x = 10; // variable declaration";

        // Extract and classify comments first
        Pattern commentPattern = Pattern.compile("//.*|/\\*[\\s\\S]*?\\*/");
        Matcher commentMatcher = commentPattern.matcher(code);

        while (commentMatcher.find()) {
            System.out.println("Token: " + commentMatcher.group() + " → Comment");
            code = code.replace(commentMatcher.group(), ""); // Remove comment from code
        }

        // Tokenize remaining code
        String[] rawTokens = code.split("\\s+|(?=[{}();,+*/=])|(?<=[{}();,+*/=])");

        for (String token : rawTokens) {
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
            } else if (token.matches("\\d+\\.\\d+")) {
                System.out.println("Token: " + token + " → Literal (Float)");
            } else if (token.matches("\".*\"")) {
                System.out.println("Token: " + token + " → Literal (String)");
            } else if (token.matches("'.'")) {
                System.out.println("Token: " + token + " → Literal (Char)");
            } else {
                System.out.println("Token: " + token + " → Identifier");
            }
        }
    }
}
