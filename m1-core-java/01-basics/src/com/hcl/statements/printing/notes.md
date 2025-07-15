```
Types of Printing Statements in Java
Java provides several ways to print output to the console. These are mostly part of the System class and its PrintStream object out.

1. System.out.println()
Prints the message and moves the cursor to the next line.
Most commonly used.

Output:

Hello, world!
2. System.out.print()
Prints the message without moving to the next line.
Useful when you want to print multiple items on the same line.

Output:

Hello, world!
3. System.out.printf()
Allows formatted output, similar to C's printf.
You can use format specifiers like %d, %s, %f, etc.

Output:

I am 25 years old.
4. System.out.format()
Same as printf(), just a different name.
Also supports format specifiers %.2f .

Output:

Pi is approximately 3.14
5. Using System.err.println()
Prints to the standard error stream.
Useful for logging errors separately from normal output.

Output:
Appears in red in many IDEs or terminals (depending on configuration).

🧠 Summary Table
Statement	Moves to New Line	Supports Formatting	Output Stream
System.out.println()	✅ Yes	❌ No	Standard Output
System.out.print()		❌ No	❌ No	Standard Output
System.out.printf()		✅ Yes	✅ Yes	Standard Output
System.out.format()		✅ Yes	✅ Yes	Standard Output
System.err.println()	✅ Yes	❌ No	Error Output


```