package in.tecresearch;

import in.tecresearch.beans.Address;
import in.tecresearch.beans.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SbA4CreateBeansClrImpl2Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SbA4CreateBeansClrImpl2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(createStudentObj().toString());
    }
    @Bean
    public Address createObjAddr(){
        return new Address(130,"Mokalpur","Varansi","Uttar Pradesh","221104");
    }
    @Bean
    public Student createStudentObj(){
        return new Student(122,"Brijesh","9506563150","Btech",createObjAddr());
    }

}
