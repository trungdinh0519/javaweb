package javaweb.user.bo;

import java.util.List;

import javaweb.user.dao.UserDao;
import javaweb.user.model.User;

public interface UserBo {
    void setUserDao(UserDao userDao);

    boolean signin(User user);

    void save(User user);

    User getUser(String username);

    List<User> findAllUsers();

}
