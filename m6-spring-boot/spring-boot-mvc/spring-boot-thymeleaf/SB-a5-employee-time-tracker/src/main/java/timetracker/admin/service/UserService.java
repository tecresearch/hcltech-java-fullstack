package timetracker.admin.service;

import java.util.List;

import timetracker.admin.entity.User;

public interface UserService 
{
	List<User> getList();
	void createUser(User user);
	User findUserByUsername(String username);
}
