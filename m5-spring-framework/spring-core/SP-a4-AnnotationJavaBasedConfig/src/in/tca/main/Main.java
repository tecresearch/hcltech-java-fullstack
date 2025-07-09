package in.tca.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.google.gson.Gson;

import in.tca.beans.Address;
import in.tca.beans.Student;
import in.teca.resources.AnnotationJavaConfig;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext context=new AnnotationConfigApplicationContext(AnnotationJavaConfig.class);
		
		Student std=(Student)context.getBean("student");
//		Address addr=(Address)context.getBean("address");
//		std.setAddress(addr);//address injection manually
		String data=std.toString();
		
		Gson gson=(Gson)context.getBean("gsonObj");
		
		System.out.println(gson.toJson(data));
		
		
	}

}
