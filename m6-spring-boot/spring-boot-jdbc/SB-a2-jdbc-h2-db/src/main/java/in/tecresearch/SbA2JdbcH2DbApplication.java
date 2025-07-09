package in.tecresearch;

import in.tecresearch.model.Student;
import in.tecresearch.service.StudentService;
import in.tecresearch.service.StudentServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SbA2JdbcH2DbApplication {

    public static void main(String[] args) {
        ApplicationContext context=SpringApplication.run(SbA2JdbcH2DbApplication.class, args);
        Student s1=context.getBean(Student.class);
        s1.setRollno(10);
        s1.setName("Brijesh Nishad");
        s1.setMarks(78);

        StudentService service=context.getBean(StudentServiceImpl.class);
        service.addStudent(s1);

        List<Student> students=service.getStudents();
        System.out.println(students);
    }

}
