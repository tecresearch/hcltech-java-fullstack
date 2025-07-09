/*
 * Write a Java program that takes a mathematical expression as a string input and evaluates it. The expression may contain:

Integer literals
Arithmetic operators: +, -, *, /
Parentheses for grouping
Your program should correctly handle operator precedence and parentheses.
 */
package com.hcl.tokens;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

public class ExpressionEvaluator {

    public static void main(String[] args) {
        String expression = "(2 + 3) * 4 - 5";

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");

        try {
            Object result = engine.eval(expression);
            System.out.println("Result: " + result);
        } catch (ScriptException e) {
            System.out.println("Invalid expression: " + e.getMessage());
        }
    }
}
