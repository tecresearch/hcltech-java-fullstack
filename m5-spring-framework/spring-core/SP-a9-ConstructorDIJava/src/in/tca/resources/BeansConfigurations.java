package in.tca.resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import in.tca.beans.Course;
import in.tca.beans.User;

@Configuration
public class BeansConfigurations {

	@Bean("courseObjId")
	public Course createCourseObj() {
		Course course=new Course(110,"Spring Boot","6 Week",6000);
		
		return course;
	}
	
	@Bean("userObjId")
	public User createUserObject() {
		User user=new User(101,"mrjacks","12311","bnlv1212@gmail.com",createCourseObj());
		
		return user;
	}
	
}
