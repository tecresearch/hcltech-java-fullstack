package com.hcl.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EfficientSearchElement {

	public static void main(String[] args) {

		List<Integer> arr=Arrays.asList(5,6,7,8,29,44,18,17,23,88,29);
		SearchElement(arr);
	}

	private static void SearchElement(List<Integer> arr) {
		
	Map<Integer,Integer> map=new HashMap<>();
		
		for(int i=0; i<arr.size(); i++) {
			map.put(arr.get(i),i);
		}

		int element=23;
		if(map.containsKey(element)) {
			int index=map.get(element);
			System.out.println("Found "+element+" at index "+ index);
		}else {
			System.out.println("Not Found");
		}
		
	}

}
