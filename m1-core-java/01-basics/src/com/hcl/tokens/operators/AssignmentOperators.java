package com.hcl.tokens.operators;
public class AssignmentOperators {
    public static void main(String[] args) {
        int score = 50;

        score += 10; // score = score + 10
        System.out.println("After += 10: " + score);

        score -= 5; // score = score - 5
        System.out.println("After -= 5: " + score);

        score *= 2; // score = score * 2
        System.out.println("After *= 2: " + score);

        score /= 3; // score = score / 3
        System.out.println("After /= 3: " + score);

        score %= 4; // score = score % 4
        System.out.println("After %= 4: " + score);
    }
}
