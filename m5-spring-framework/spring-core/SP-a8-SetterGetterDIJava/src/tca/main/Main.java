package tca.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.tca.beans.User;

import in.tca.resources.BeansConfigurations;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext context =new AnnotationConfigApplicationContext(BeansConfigurations.class);
		User user=(User)context.getBean("userObjId");
		System.out.println(user);
	}

}
