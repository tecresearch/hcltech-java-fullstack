package timetracker.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import timetracker.admin.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> 
{
	User findByUsername(String username);
}
