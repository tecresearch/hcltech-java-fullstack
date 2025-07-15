/*
 * You're redirecting the standard output (System.out) to a file named output.txt. So instead of printing to the console, the output will be written to that file.
 Where to Find the Output
The file output.txt will be created in the root directory of your project.
If you're using an IDE like Eclipse, IntelliJ IDEA, or VS Code, it will usually be in the project folder (same level as src or bin).
If you're running from the command line, it will be created in the current working directory (where you ran the java command).
 */
package com.hcl.input_output;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class CustomizeSystemOutputToFile {
	public static void main (String args[]) throws FileNotFoundException {
		PrintStream fileOut=new PrintStream("output.txt");
		System.setOut(fileOut);
		System.out.println("This line goes to file");
	}
	
}

