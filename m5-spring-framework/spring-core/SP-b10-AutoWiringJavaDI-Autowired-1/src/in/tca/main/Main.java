package in.tca.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.tca.config.AutoConfig;
import in.tca.model.User;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context=new AnnotationConfigApplicationContext(AutoConfig.class);
		User user1=(User)context.getBean("userId");
		System.out.println(user1);
	}

}
