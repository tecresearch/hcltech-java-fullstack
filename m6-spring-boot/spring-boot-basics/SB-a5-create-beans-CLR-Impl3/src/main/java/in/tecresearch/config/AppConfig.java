package in.tecresearch.config;

import in.tecresearch.beans.Address;
import in.tecresearch.beans.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public CommandLineRunner cmdLineRunner(){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                System.out.println(createObjStd());
            }
        };
    }

    @Bean
    public Address createObjAdr(){
        return new Address("Varanasi","Uttar Pradesh");
    }
    @Bean
    public Student createObjStd(){
        return new Student("Brijesh Nishad","B.Tech",createObjAdr());
    }
}
