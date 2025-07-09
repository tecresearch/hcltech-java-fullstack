package in.tecresearch.config;

import in.tecresearch.repository.StudentRepository;
import in.tecresearch.service.StudentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

        @Bean
        public StudentRepository studentRepository(){
            return new StudentRepository();
        }

        @Bean
        public StudentService studentService(StudentRepository studentRepository){
            return new StudentService(studentRepository);
        }
}
