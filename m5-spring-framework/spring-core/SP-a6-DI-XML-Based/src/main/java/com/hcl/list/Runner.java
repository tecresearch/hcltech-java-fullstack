package com.hcl.list;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context=new ClassPathXmlApplicationContext("list_bean_config.xml");
		Student s1=(Student)context.getBean("student1");
		System.out.println(s1.toString());
	}

}
