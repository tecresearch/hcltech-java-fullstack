package in.tecresearch.repository;
import in.tecresearch.entity.User;
import in.tecresearch.mapper.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public UserRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public boolean insertUser(User user){
        boolean status;
        String INSERT_SQL_QUERY="insert into users(name,role) value(?,?)";
        try {
            int count= jdbcTemplate.update(INSERT_SQL_QUERY,user.getName(),user.getRole());
            status= count > 0;
        } catch (DataAccessException e) {
            throw new RuntimeException(e);
        }
        return status;
    }
    @Override
    public boolean updateUser(User user){
        boolean status;
        String UPDATE_SQL_QUERY="update users set name=? where role=?";
        try {
            int count= jdbcTemplate.update(UPDATE_SQL_QUERY,user.getName(),user.getRole());
            status= count > 0;
        } catch (DataAccessException e) {
            throw new RuntimeException(e);
        }
        return status;
    }
    @Override
    public boolean deleteUserByRole(String role){
        boolean status;
        String DELETE_SQL_QUERY="delete from  users where role=?";
        try {
            int count= jdbcTemplate.update(DELETE_SQL_QUERY,role);
            status= count > 0;
        } catch (DataAccessException e) {
            throw new RuntimeException(e);
        }
        return status;
    }
    @Override
    public  User getUserByRole(String role){
        String SELECT_SQL_QUERY="select * from users where role=?";
        return jdbcTemplate.queryForObject(SELECT_SQL_QUERY,new UserRowMapper(),role);
    }
    @Override
    public List<User> getAllUsers(){
        String SELECT_SQL_QUERY="select * from users";
        return jdbcTemplate.query(SELECT_SQL_QUERY,new UserRowMapper());
    }

}
