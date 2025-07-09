package in.tecresearch.repository;

import in.tecresearch.model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository {
    void save(Student s);

    List<Student> findAll();
}
