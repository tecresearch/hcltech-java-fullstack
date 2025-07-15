package com.hcl.tokens.operators;
import java.util.Scanner;

public class LogicalOperators {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter age: ");
        int age = sc.nextInt();

        System.out.print("Enter citizenship: ");
        String citizenship = sc.next();

        System.out.print("Do you have a voter ID (true/false)? ");
        boolean hasVoterID = sc.nextBoolean();

        // Check eligibility using logical operators
        if (age >= 18 && citizenship.equalsIgnoreCase("Indian") && hasVoterID) {
            System.out.println("Eligible to vote.");
        } else {
            System.out.println("Not eligible to vote.");
        }
    }
}
