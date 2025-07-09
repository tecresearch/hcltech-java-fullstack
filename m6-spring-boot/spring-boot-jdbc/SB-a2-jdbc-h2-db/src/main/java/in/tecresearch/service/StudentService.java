package in.tecresearch.service;

import in.tecresearch.model.Student;

import java.util.List;

public interface StudentService {

    void addStudent(Student s);

    List<Student> getStudents();
}
