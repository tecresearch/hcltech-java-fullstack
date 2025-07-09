package in.tca.resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import in.tca.beans.Course;
import in.tca.beans.User;

@Configuration
public class BeansConfigurations {

	@Bean("courseObjId")
	public Course createCourseObj() {
		Course course=new Course();
		course.setCid(101);
		course.setName("Spring Boot");
		course.setDuration("6 Week");
		course.setPrice(6000);
		return course;
	}
	
	@Bean("userObjId")
	public User createUserObject() {
		User user=new User();
		user.setId(101);
		user.setUsername("Mr.Brijesh");
		user.setEmail("Bnlv1212@gmail.com");
		user.setPassword("Admin@Brijesh");
		user.setCourse(createCourseObj());
		return user;
	}
	
}
