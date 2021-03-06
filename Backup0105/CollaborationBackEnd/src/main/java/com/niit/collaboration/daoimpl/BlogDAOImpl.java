package com.niit.collaboration.daoimpl;



import java.util.List;


import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaboration.dao.BlogDAO;
import com.niit.collaboration.model.Blog;


@Transactional
@Repository("blogDAO")
public class BlogDAOImpl implements BlogDAO {

	@Autowired
	private SessionFactory sessionFactory;

	

	@SuppressWarnings("unchecked")
	public List<Blog> list() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		List<Blog> blogs = session.createQuery("from Blog").list();
		tx.commit();
		session.flush();
		session.close();
		return blogs;
	}

	public boolean save(Blog blog) {

		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.saveOrUpdate(blog);
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

	public boolean update(Blog blog) {
		try {
			System.out.println("BlogDao Update called***");
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			//System.out.println("blog=" + blog.getBlog().getName() + "& blog =" + blog.getBlog().getName());


			session.update(blog);
			session.getTransaction().commit();
			session.flush();
			session.close();
			System.out.println("ProductDao Update finishd***");
			return true;
		}

		catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean delete(Blog blog) {

		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.clear();
			session.delete(blog);
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

	public Blog getBlogByID(int id) {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		// Blog blog = (Blog) session.createQuery("from Blog where
		// id=" + id).uniqueResult();

		Blog blog = (Blog) session.get(Blog.class, id);
		tx.commit();
		session.flush();
		session.close();
		return blog;

	}

	public Blog getBlogByName(String name) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Blog blog = (Blog) session.createQuery("from Blog where name='" + name + "'").uniqueResult();
		tx.commit();
		session.flush();
		session.close();
		return blog;

	}

	
}
