package com.hcl.arrays;

import java.util.ArrayList;
import java.util.Collections;

public class AlternativeDifference {

	public static int checkDiff(int []arr) {
		int result = 0 ;
		int larg = 0;
		ArrayList<Integer> arr1=new ArrayList<Integer>();
		for(int i=0; i<arr.length; i++) {
			int j=i;
			if(j<arr.length-2) {
				int absValue=Math.abs(arr[j]-arr[j+2]);
				arr1.add(absValue);
				
			}
			
		}
		System.out.println(arr.toString());
		larg=Collections.max(arr1);
		System.out.println(larg);
		for(int i=0;i<arr.length-2;i++) {
			int j=i;
			if(Math.abs(arr[j]-arr[j+2])==larg) {
				if(arr[j]<arr[j+2]) {
					return arr[j];
				}else {
					return arr[j+2];
				}
			}
		}
		return result;
	}
	public static void main(String[] args) {
		
		int []arr= {2,19,3,5,7,1,8,9,11,7};
		System.out.println(checkDiff(arr));

	}

}
