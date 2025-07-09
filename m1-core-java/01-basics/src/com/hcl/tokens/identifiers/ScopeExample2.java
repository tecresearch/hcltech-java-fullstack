
/*
 * 2. Instance Scope
An instance variable is declared inside a class but outside any method. It belongs to the object (instance) of the class.
 */
package com.hcl.tokens.identifiers;
public class ScopeExample2 {
    int instanceVar = 20; // Instance scope

    public void show() {
        System.out.println("Instance variable: " + instanceVar);
    }
}
