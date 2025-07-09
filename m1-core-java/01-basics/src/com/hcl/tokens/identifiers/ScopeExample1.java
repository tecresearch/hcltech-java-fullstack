/**
 * 1. Local Scope
A local variable is declared inside a method, constructor, or block and is accessible only within that block.
 */
package com.hcl.tokens.identifiers;
public class ScopeExample1 {
    public void display() {
        int localVar = 10; // Local scope
        System.out.println("Local variable: " + localVar);
    }

    public void anotherMethod() {
        // System.out.println(localVar); // ❌ Error: localVar not accessible here
    }
}
