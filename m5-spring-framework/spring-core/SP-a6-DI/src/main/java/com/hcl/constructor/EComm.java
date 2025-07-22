package com.hcl.constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EComm {

	public static void main(String[] args) {
		String xmlBeanLocation="constructor_bean_config.xml";
		ApplicationContext context=new ClassPathXmlApplicationContext(xmlBeanLocation);
//		Product product=new Product(101, "HP Pro Book", 85000);
//		User user1=new User(111,"Brijesh Nishad",product);
		User user1=(User)context.getBean("user1");
		System.out.println(user1);
		
	}

}
