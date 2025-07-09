package in.tecresearch.service;

import in.tecresearch.model.Student;
import in.tecresearch.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {


    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void addStudent(Student s) {
       studentRepository.save(s);

    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }
}
