package in.tecresearch;

import in.tecresearch.service.StudentService;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SbA6ManualDiApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context= SpringApplication.run(SbA6ManualDiApplication.class, args);
        StudentService studentService=context.getBean(StudentService.class);
        studentService.displayStudents();
    }

}
