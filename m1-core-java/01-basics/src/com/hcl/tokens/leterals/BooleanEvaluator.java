
/*
 * 5. Boolean Literal – Logical Expression Evaluator
Question:
Create a mini logical expression evaluator that takes boolean literals and operators (AND, OR, NOT) as input and evaluates the result.

Challenge: Parse expressions like "true AND false OR NOT true" and compute the result.
 */
package com.hcl.tokens.leterals;
public class BooleanEvaluator {
    public static void main(String[] args) {
        boolean a = true;
        boolean b = false;
        boolean c = true;

        boolean result = (a && b) || !c;
        System.out.println("Result of (true AND false) OR NOT true: " + result);
    }
}
