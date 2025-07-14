package com.hcl.valid_word;

public class ValidWords {

    public static void main(String[] args) {
        String input = "This is password @checker";
        System.out.println("Valid word count: " + checkWord(input));
    }

    private static int checkWord(String str) {
        int validWordCount = 0;
        String[] words = str.split(" ");

        for (String word : words) {
            if (word.length() <= 3) continue;

            boolean hasVowel = false;
            boolean hasConsonant = false;
            boolean hasSpecialChar = false;

            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);

                if (!Character.isLetterOrDigit(c)) {
                    hasSpecialChar = true;
                    break;
                }

                if ("aeiouAEIOU".indexOf(c) != -1) {
                    hasVowel = true;
                } else if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                    hasConsonant = true;
                }
            }

            if (!hasSpecialChar && hasVowel && hasConsonant) {
                validWordCount++;
            }
        }

        return validWordCount;
    }
}
