package com.hcl.tokens.conversion;

public class TypeConversion {

	public static void main(String[] args) {
		TypeConversion.main(args,args);
		 System.out.println("one args");

	}
	public static void main(String[] args,String []agrs) {
		
		System.out.println("Two agrs");
		byte a=10;
		byte b=20;
		int result=a+b;//type promotion
		System.out.println(result);
		int c=10;
		long d=c;//implicit type casting/ uper casting
		System.out.println(d);
		byte e=(byte)c;//explicit type casting
		System.out.println(e);
		
		

	}

}
