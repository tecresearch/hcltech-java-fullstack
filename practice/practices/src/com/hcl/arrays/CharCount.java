package com.hcl.arrays;

import java.util.Scanner;

public class CharCount {

	public static void main(String[] args) {
		
             Scanner sc=new Scanner(System.in);
             String str=sc.nextLine();
             String result=charCount(str);
             System.out.println(result);
	}

	private static String charCount(String str) {
		String result="";
		int count=1;
		for(int i=0; i<str.length();i++) {	
			if(i==str.length()-1)return ""+str.charAt(i)+count;
			while(str.charAt(i)==str.charAt(i+1)) {
				count++;
				i++;
				if(i==str.length()-1) {
					break;
				}
			}
			result+=""+str.charAt(i)+count;
			count=1;		
		}
		
		
		return result;
	}

}
