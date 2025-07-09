package in.tecresearch.repository;

import in.tecresearch.models.Student;

import java.util.Arrays;
import java.util.List;

public class StudentRepository {
    public List<Student> getAllStudents(){
        System.out.println("Fetching all students");
        return Arrays.asList(
                new Student(1,"Brijesh","Backend Devloper"),
                new Student(2,"Abhi","UI/UX Devloper"),
                new Student(3,"Rohit","Frontend Devloper")
        );
    }
}
