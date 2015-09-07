package javaweb.user.dao;

import java.util.List;

import javaweb.user.model.User;

public interface UserDao {

	User getUser(String username);
	
	void addUser(User user);
	
	void updateUser(User user);
	
	List<User> findAllUser();
	
	boolean isExist(String username);
}
