/*
 *  Why Are Separators Important?
They define structure (e.g., blocks, arrays, method calls).
They separate tokens so the compiler can understand the code.
They prevent ambiguity in parsing.
 */

package com.hcl.tokens.seperators;
public class SeparatorExample {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};  // {} and , used
        for (int num : numbers) {  // : used in enhanced for loop
            System.out.println(num);  // . and () used
        }
    }
}
