
/*
 *  5. Find Prime Numbers in a Range
Question:
Write a Java program to print all prime numbers between 1 and 100.
 */

package com.hcl.tokens.operators;
public class PrimeNumbers {
    public static void main(String[] args) {
        for (int num = 2; num <= 100; num++) {
            boolean isPrime = true;

            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    isPrime = false; // Not prime
                    break;
                }
            }

                           System.out.print(num + " "); // Print prime number
            }
        }
    }

