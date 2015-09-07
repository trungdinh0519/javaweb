/**
 * 
 */
package javaweb.user.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import javaweb.user.dao.UserDao;
import javaweb.user.model.User;

/**
 * @author admin
 *
 */
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	/**
	 * 
	 * @see javaweb.user.dao.UserDao#getUser(java.lang.String)
	 */
	@Override
	public User getUser(String username) {

		@SuppressWarnings("rawtypes")

		List users = getHibernateTemplate().find("from User where username=?", username);

		if (users != null && !users.isEmpty()) {
			return (User) users.get(0);
		}

		return null;
	}

	/**
	 * 
	 * @see javaweb.user.dao.UserDao#findAllUser()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAllUser() {
		List<User> users = (List<User>) getHibernateTemplate().find("from User");

		return users;
	}

	/**
	 * 
	 * @see javaweb.user.dao.UserDao#isExist(java.lang.String)
	 */
	@Override
	public boolean isExist(String username) {

		@SuppressWarnings("rawtypes")
		List users = getHibernateTemplate().find("from User where username=?", username);
		if (users == null || users.isEmpty()) {
			return false;
		}

		return true;
	}

	/**
	 * 
	 * @see javaweb.user.dao.UserDao#saveUser(javaweb.user.model.User)
	 */
	@Override
	public void addUser(User user) {
		user.setCreatedDate(new Date());
		user.setUpdatedDate(new Date());
		user.setDelFlg(0);
		getHibernateTemplate().save(user);
	}

	/**
	 * 
	 * @see javaweb.user.dao.UserDao#updateUser(javaweb.user.model.User)
	 */
	@Override
	public void updateUser(User user) {

		user.setUpdatedDate(new Date());
		getHibernateTemplate().save(user);
	}
}
