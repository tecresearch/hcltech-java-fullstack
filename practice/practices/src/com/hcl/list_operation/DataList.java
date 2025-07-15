package com.hcl.list_operation;

import java.util.ArrayList;
import java.util.List;

public class DataList {
	public List<Employee> ans;

	DataList() {
		this.ans = new ArrayList<Employee>();
	}

	public void addElement(Employee s) {
		ans.add(s);
	}

	public List<Employee> getList() {
		return ans;
	}

	public String getElement(String s) {
		for (Employee v : ans) {
			if (v.getName().equals(s)) {
				return s;
			}
		}
		return null;

	}

}
