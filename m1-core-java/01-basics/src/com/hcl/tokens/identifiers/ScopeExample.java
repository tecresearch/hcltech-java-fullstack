/*
 * 3. Class Scope (Static)
A class variable is declared with the static keyword. It belongs to the class itself, not to any object.
 */
package com.hcl.tokens.identifiers;
public class ScopeExample {
    static int classVar = 30; // Class scope

    public static void printClassVar() {
        System.out.println("Class variable: " + classVar);
    }
}
