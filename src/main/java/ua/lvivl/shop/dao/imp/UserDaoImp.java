package ua.lvivl.shop.dao.imp;

import java.util.List;

import org.hibernate.Session;

import ua.lviv.shop.domain.User;
import ua.lvivl.shop.dao.UserDao;
import util.HibernateUtil;

public class UserDaoImp implements UserDao {

	private Session session = null;

	public void addUser(User user) {
		try {
			beginTransaction();
			session.save(user);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeSession();
		}

	}

	public void deleteUser(User user) {
		try {
			beginTransaction();
			session.delete(user);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeSession();
		}

	}

	public User getUser(int id) {
		User user = null;
		try {
			beginTransaction();
			user = (User) session.get(User.class, id);
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeSession();
		}
		return user;
	}

	public User getUser(String name) {
		User user = null;
		try {
			beginTransaction();
			user = (User) session.get(User.class, name);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeSession();
		}
		return user;
	}

	public List<User> getAllUsers() {
		List<User> users = null;
		try {
			beginTransaction();
			users = session.createCriteria(User.class).list();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeSession();
		}
		return users;
	}

	public void updateUser(User user) {
		try {
			beginTransaction();
			session.update(user);
			session.getTransaction().commit();
		} finally {
			closeSession();
		}

	}

	private void beginTransaction() {
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
	}

	private void closeSession() {
		if (session != null && session.isOpen())
			session.close();
	}

}
