/*
 * To take input from both a file (input.txt) and the console, and 
 * then print all of it to a file (output.txt), you can combine both 
 * input methods in one program.
 */

package com.hcl.input_output;

import java.io.*;
import java.util.Scanner;

public class CustomizeSystemInputFromConsole {
    public static void main(String[] args) throws FileNotFoundException {
        // Step 1: Prepare to read from input.txt
        File inputFile = new File("input.txt");
        Scanner fileScanner = new Scanner(inputFile);

        // Step 2: Prepare to read from console
        Scanner consoleScanner = new Scanner(System.in);

        // Step 3: Redirect System.out to output.txt
        PrintStream fileOut = new PrintStream(new FileOutputStream("output.txt"));
        System.setOut(fileOut);

        // Step 4: Print contents of input.txt to output.txt
        System.out.println("Contents of input.txt:");
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            System.out.println(line);
        }

        // Step 5: Take input from console and print to output.txt
        System.out.println("\nEnter some lines (type 'exit' to stop):");
        while (true) {
            String userInput = consoleScanner.nextLine();
            if (userInput.equalsIgnoreCase("exit")) {
                break;
            }
            System.out.println(userInput);
        }

        // Step 6: Close resources
        fileScanner.close();
        consoleScanner.close();
        fileOut.close();
    }
}
