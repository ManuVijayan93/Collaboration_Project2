package com.niit.collaboration.test;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.dao.UserDAO;
import com.niit.collaboration.daoimpl.UserDAOImpl;
import com.niit.collaboration.model.User;

public class UserTestCase {

	@Autowired
	private static AnnotationConfigApplicationContext context;
	@Autowired
	private static User user;
	@Autowired
	private static UserDAO userDAO;

	@BeforeClass
	public static void initialize() {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.collaboration.*");
		context.refresh();
		user = (User) context.getBean(User.class);
		System.out.println(user);

		userDAO = (UserDAO) context.getBean("udao");
		System.out.println(userDAO);

	}
// create
	/*
	  @Test public void createUserTestCase() { user.setId(39);
	  user.setName("hhnu"); user.setPassword("1231"); user.setMail("Manu");
	  user.setContact("985885855"); user.setRole("ROLE_ADMIN");
	  user.setEnabled(true); boolean flag = userDAO.save(user);
	  Assert.assertEquals("createUserTestCase", true, flag); }
	 */
//Delete
	/*@Test 
	  public void deleteUserTestCase() { 
		User user = (User)userDAO.getUser(3004); 
		boolean flag = userDAO.delete(user);
	  Assert.assertEquals("delete user test case", true, flag); 
	  
	}
	
	*/

	//Update
	/*@Test 
	public void updateUserTestCase()
	{ 
		User user = (User)userDAO.getUser(39); 
		user.setId(311); 
		user.setName("Anu");
	  user.setPassword("123"); 
	  user.setMail("mn@gmail");
	 user.setContact("985885833"); 
	 user.setRole("ROLE_ADMIN");
	 
	 boolean flag = userDAO.update(user);
	 
	 Assert.assertEquals("update user test case", true, flag); }*/
	

	@Test
	public void validateCredentialsTestCase() { 
		boolean flag=userDAO.validate("Anu", "123");
	  assertEquals("ValidateCredentialsTestCase",true,flag);
	  
	  }
	  

}
