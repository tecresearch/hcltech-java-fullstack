package com.hcl.tokens.operators;
import java.util.Scanner;

public class RelationalOperators {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter three numbers: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c=sc.nextInt();
        if (a >= b && a >= c) {
            System.out.println("Greatest: " + a);
        } else if (b >= a && b >= c) {
            System.out.println("Greatest: " + b);
        } else {
            System.out.println("Greatest: " + c);
        }

        // Check equality
        if (a == b || b == c || a == c) {
            System.out.println("At least two numbers are equal.");
        } else {
            System.out.println("All numbers are different.");
        }
    }
}
