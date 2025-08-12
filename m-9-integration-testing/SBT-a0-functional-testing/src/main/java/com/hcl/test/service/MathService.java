package com.hcl.test.service;

import org.springframework.stereotype.Service;
/*
 * Note* Return only integer value 
 * 
 * 
 */
@Service
public class MathService {
	
	public int addTwoNumber(int a,int b) {
	    /*
	     * TODO Write your code here...
	     * 
	     * 
	     */
		return a+b;
	}

	public int getCube(int number){
		return number*number*number;
	}

	public int getMax(int[] arr) {
		int max=arr[0];
		for(int i=1;i<arr.length;i++){
			if(arr[i]>max){
				max=arr[i];
			}
		}
		return max;
	}
}
