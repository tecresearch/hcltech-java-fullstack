/*
 * Prints to the standard error stream instead of standard output.

🔍 How it works:
Useful for logging errors or debugging.
Often appears in red in IDEs or terminals.
 */

package com.hcl.statements.printing;
public class ErrorExample {
    public static void main(String[] args) {
        System.err.println("Something went wrong!");
    }
}
