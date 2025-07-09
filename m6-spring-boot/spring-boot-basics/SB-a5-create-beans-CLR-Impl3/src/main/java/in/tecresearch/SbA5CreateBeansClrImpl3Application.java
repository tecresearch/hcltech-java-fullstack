package in.tecresearch;

import in.tecresearch.beans.MyClass;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SbA5CreateBeansClrImpl3Application  {

    public static void main(String[] args) {

       MyClass m1= SpringApplication.run(SbA5CreateBeansClrImpl3Application.class, args).getBean(MyClass.class);
       //this way not recommended due to tight coupling
        m1.setId(101);
        m1.setName("Brijesh ");
        m1.setAge(23);
       System.out.println(m1);
    }


}
