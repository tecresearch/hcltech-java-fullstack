package in.tecresearch.main;

import org.collectionframework.util.ArrayList;

public class Main {

	public static void main(String[] args) {
	
		
		ArrayList<String> list=new ArrayList<>();
	
		boolean status=list.add("mn");
		list.add("hj");
		list.add("lk");
		list.add("uu");
		list.add(2,"5");
		String value=list.get(0);
		System.out.println(value);
		System.out.println(status);
		System.out.println(list);

	}

}
