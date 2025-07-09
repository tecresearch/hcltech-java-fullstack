package in.tecresearch.repository;

import in.tecresearch.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository{
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(Student s) {

        String SQL="insert into student (rollno,name,marks) values (?,?,?)";
        int row=jdbcTemplate.update(SQL,s.getRollno(),s.getName(),s.getMarks());
        System.out.println(row+" effected");
        System.out.println("Student has been added successfully");

    }

    @Override
    public List<Student> findAll() {
        String SQL="select * from student";
//        RowMapper<Student> mapper=new RowMapper<Student>() {
//            @Override
//            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
//                Student s=new Student();
//                s.setRollno(rs.getInt("rollno"));
//                s.setName(rs.getString("name"));
//                s.setMarks(rs.getInt("marks"));
//                return s;
//            }
//        };
        return jdbcTemplate.query(SQL,(rs,rowNum)->{
                Student s=new Student();
                s.setRollno(rs.getInt("rollno"));
                s.setName(rs.getString("name"));
                s.setMarks(rs.getInt("marks"));
                return s;
        });

    }

}
