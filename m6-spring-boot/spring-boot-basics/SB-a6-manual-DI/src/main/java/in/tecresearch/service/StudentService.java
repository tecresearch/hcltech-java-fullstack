package in.tecresearch.service;

import in.tecresearch.models.Student;
import in.tecresearch.repository.StudentRepository;

import java.util.List;
//@Service not used cause of Manual  DI
public class StudentService {
    private  final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void displayStudents(){
        List<Student> student=studentRepository.getAllStudents();
        student.forEach(System.out::println);
    }
}
