package javaweb.user.bo.impl;

import java.util.List;

import javaweb.user.bo.UserBo;
import javaweb.user.dao.UserDao;
import javaweb.user.model.User;
import javaweb.utils.StringUtils;

public class UserBoImpl implements UserBo {

	protected UserDao userDao;

	/**
	 * 
	 * @see javaweb.user.dao.UserDao#setUserDao(javaweb.user.dao.UserDao)
	 */
	@Override
	public void setUserDao(UserDao userDao) {
		// TODO Auto-generated method stub
		this.userDao = userDao;
	}

	@Override
	public boolean signin(User user) {

		// check empty.
		if (user == null || StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())) {
			return false;
		}

		// check exist
		boolean existed = userDao.isExist(user.getUsername());
		if (!existed)
			return false;

		// check sha password
		User userInDB = userDao.getUser(user.getUsername());
		if (StringUtils.isEmpty(userInDB.getPassword()))
			return false;

		if (StringUtils.sha256(user.getPassword()).equals(userInDB.getPassword())) {
			return true;
		}

		return false;
	}

	@Override
	public User getUser(String username) {

		return userDao.getUser(username);
	}

	@Override
	public void save(User user) {

		// check empty.
		if (user == null || StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())) {
			return;
		}

		if (userDao.isExist(user.getUsername())) {

			User userInDB = userDao.getUser(user.getUsername());
			userInDB.setEmail(user.getEmail());
			userInDB.setPassword(StringUtils.sha256(user.getPassword()));

			// update User
			userDao.updateUser(userInDB);

		} else {

			// Add new User
			userDao.addUser(user);
		}
	}

	@Override
	public List<User> findAllUsers() {
		return userDao.findAllUser();
	}
}