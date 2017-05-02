package com.niit.collaboration.test;

import org.junit.Assert;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.dao.BlogDAO;
import com.niit.collaboration.model.Blog;

public class BlogTestCase {
	@Autowired
	private static AnnotationConfigApplicationContext context;
	@Autowired
	private static Blog blog;
	@Autowired
	private static BlogDAO blogDAO;

	@BeforeClass
	public static void initialize() {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		blog = (Blog) context.getBean("blog");

		blogDAO = (BlogDAO) context.getBean("blogDAO");

	}

	@Test
	public void createBlogTestCase() {
		blog.setId(3004);
		blog.setTitle("My blog");

		blog.setDescription("colloboartion blog");

		boolean flag = blogDAO.save(blog);
		Assert.assertEquals("createBlogTestCase", true, flag);
	}

	@Test
	public void deleteBlogTestCase() {
		Blog blog = (Blog) blogDAO.getBlogByID(3004);
		boolean flag = blogDAO.delete(blog);
		Assert.assertEquals("delete blog test case", true, flag);
	}

	@Test
	public void updateBlogTestCase() {
		Blog blog = (Blog) blogDAO.getBlogByID(3007);
		blog.setId(3012);
		blog.setTitle("MCameras");

		blog.setDescription("collaboration blog");

		boolean flag = blogDAO.update(blog);

		Assert.assertEquals("update blog test case", true, flag);
	}

}
