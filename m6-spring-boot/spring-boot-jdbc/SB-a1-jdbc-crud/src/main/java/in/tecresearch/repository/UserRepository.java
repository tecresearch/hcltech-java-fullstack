package in.tecresearch.repository;

import in.tecresearch.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public interface UserRepository {

    public boolean insertUser(User user);
    public boolean updateUser(User user);
    public boolean deleteUserByRole(String role);
    public  User getUserByRole(String role);
    public List<User> getAllUsers();
}
