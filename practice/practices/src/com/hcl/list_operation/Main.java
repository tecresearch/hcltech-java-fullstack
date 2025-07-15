package com.hcl.list_operation;

public class Main {

	public static void main(String[] args) {
		DataList d=new DataList();
		d.addElement(new Employee(123,"Brijesh Nishad"));
		d.addElement(new Employee(12,"v Nishad"));
		d.addElement(new Employee(23,"ok Nishad"));
		d.addElement(new Employee(13,"Brijesh"));
		System.out.println(d.getList());
		System.out.println(d.getElement("Brijesh"));

	}

}
