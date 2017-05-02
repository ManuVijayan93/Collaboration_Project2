package com.niit.collaboration.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.niit.collaboration.dao.UserDAO;
import com.niit.collaboration.model.User;

@Transactional
@Repository("udao")
@Component
public class UserDAOImpl implements UserDAO {
	@Autowired
	private SessionFactory sessionFactory;

	// List All users
	public List<User> list() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<User> users = session.createQuery("from User").list();
		tx.commit();
		session.flush();
		session.close();
		return users;

	}

	// GetUserById
	public User getUser(int id) {

		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			User user = (User) session.get(User.class, id);
			tx.commit();
			session.flush();
			session.close();
			return user;

		}

		catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	// GetUserByName
	public User getUser(String name) {

		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			String hql = "from User where name='" + name + "'";

			User user = (User) session.createQuery(hql).uniqueResult();
			tx.commit();
			session.flush();
			session.close();
			return user;

		}

		catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	// save user
	public User save(User user) {
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			user.setRole("ROLE_USER");
			user.setEnabled(true);
			session.save(user);
			tx.commit();
			session.flush();
			session.close();

		}

		catch (Exception e) {
			System.out.println("exception occured******");
			e.printStackTrace();

		}
		return user;

	}

	// upadating the user
	public boolean update(User user) {
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.saveOrUpdate(user);
			tx.commit();
			session.flush();
			session.close();
			return true;
		}

		catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean delete(User user) {

		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.clear();
			session.delete(user);
			session.getTransaction().commit();
			session.flush();
			session.close();
			return true;
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

	// validate the User
	public boolean validate(String name, String password) {
		// select * from user where id='manu' and password='manu';
		// String hql="from user where id='manu' and password='manu';

		String hql = "from User where name='" + name + "'and password='" + password + "'";
		Session session = sessionFactory.openSession();
		User user = (User) session.createQuery(hql).uniqueResult();
		if (user == null)
			return false;

		return true;
	}

}
