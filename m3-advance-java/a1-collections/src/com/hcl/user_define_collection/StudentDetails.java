package com.hcl.user_define_collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class StudentDetails {

	public static void main(String[] args) {
		
		Student s1=new Student("Brijesh", 1);
		Student s2=new Student("Rohit", 2);
		Student s3=new Student("Raj", 3);
		Student s4=new Student("Raj", 3);
		
//		Set<Student> s5=new HashSet<>();
		List<Student> s5=new ArrayList<>();
		s5.add(s1);
		s5.add(s2);
		s5.add(s3);
		s5.add(s4);
		
		Iterator<Student> i1=s5.iterator();
		while(i1.hasNext()) {
			Student s6=i1.next();
			System.out.println(s6.name+" "+ s6.age);
		}
		
		
		class Sorting implements  Comparator<Student>{
			

			@Override
			public int compare(Student o1, Student o2) {
				
//				return o1.getName().compareTo(o2.getName());
				return Integer.compare(o1.getAge(), o2.getAge());

				
			}
			
		}
		
		Collections.sort(s5,new Sorting());
		System.out.println(s5);
		
		
		
	}

}
