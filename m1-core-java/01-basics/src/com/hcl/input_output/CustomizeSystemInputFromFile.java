package com.hcl.input_output;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class CustomizeSystemInputFromFile {
    public static void main(String[] args) throws FileNotFoundException {
        // Step 1: Read from input.txt
        File inputFile = new File("input.txt");
        Scanner scanner = new Scanner(inputFile);

        // Step 2: Redirect System.out to output.txt
        PrintStream fileOut = new PrintStream(new FileOutputStream("output.txt"));
        System.setOut(fileOut);

        // Step 3: Print each line from input.txt to output.txt
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
        }

        // Close resources
        scanner.close();
        fileOut.close();
    }
}
