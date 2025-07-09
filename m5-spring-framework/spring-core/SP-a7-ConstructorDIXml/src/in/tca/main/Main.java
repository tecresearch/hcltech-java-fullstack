package in.tca.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.tca.beans.Student;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String conf="/in/tca/config/beans.xml";
		ApplicationContext context=new ClassPathXmlApplicationContext(conf);
		Student std1=(Student)context.getBean("stdId");
		System.out.println(std1);
		
		
	}

}
