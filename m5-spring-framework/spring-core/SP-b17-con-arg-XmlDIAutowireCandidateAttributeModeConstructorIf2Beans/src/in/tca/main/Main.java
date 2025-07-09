package in.tca.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.tca.model.User;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String config_path="/in/tca/config/autoConfig.xml";
		ApplicationContext context =new ClassPathXmlApplicationContext(config_path);
		User user1=(User)context.getBean("userId");
		System.out.println(user1);
	}

}
