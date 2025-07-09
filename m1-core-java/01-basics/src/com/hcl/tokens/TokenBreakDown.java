/*Book:Grady Booch OOP Analysis and Design
 * James Aurther Gosline :1995
 * Java Features::
 * OOPS
 * Platform Independent
 * Robust
 * Secure
 * Multithreaded
 * Portable
 * Architecture Neutral
 * 🔍 Token Breakdown
Token Type	Example	Explanation
Keyword	public, class, static, void, int, String	Reserved words with special meaning in Java.
Identifier	HelloWorld, main, args, number, message	Names for classes, methods, variables.
Literal	10, "Hello, Java!"	Constant values.
Operator	=, +	Assignment and concatenation operators.
Separator	(), {}, [], ;, .	Used to group code and separate statements.
Method Call	System.out.println(...)	A method invocation using dot notation.
 */

package com.hcl.tokens;

public class TokenBreakDown {
	public static void main(String[] args)
	{
		int number = 10;
		String message = "Hello, Java!";
		System.out.println(message + " The number is " + number);
	}
}
