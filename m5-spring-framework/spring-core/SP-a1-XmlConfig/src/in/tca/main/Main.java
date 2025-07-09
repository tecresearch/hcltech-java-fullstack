package in.tca.main ;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.beans.BeansException; // Import the BeansException

import com.google.gson.Gson;
import in.tca.beans.Student;

public class Main {
    public static void main(String[] args) {
        String configLocation = "/in/tca/config/applicationContext.xml";

        try {
            ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);

            
            Gson gson = (Gson) context.getBean("gson");
            
            Student student1 = (Student) context.getBean("stdId");
            System.out.println("01:"+student1.toString());
            // Serialize the Student object to JSON
            String jsonString = gson.toJson(student1);
            System.out.println("Serialized JSON: " + jsonString);
            
            // Deserialize the JSON string back into a Student object
            Student deserializedStudent = gson.fromJson(jsonString, Student.class);
            System.out.println("Deserialized Student: " + deserializedStudent);
            System.out.println("-----------------------------------------------");
            Student student2=(Student) context.getBean("stdObj2");
            System.out.println("02:"+student2.toString());
         // Serialize the Student object to JSON
            String jString=gson.toJson(student2);
            System.out.println("Serialized Json:"+jString);
            
         // Deserialize the JSON string back into a Student object
            Student dlString = gson.fromJson(jString, Student.class);
            System.out.println("Deserialized Student: " + dlString);
            
        } catch (BeansException e) {
            e.printStackTrace(); // Handle BeansException
        } catch (Exception e) {
            e.printStackTrace(); // Handle any other exceptions
        }
    }
}
