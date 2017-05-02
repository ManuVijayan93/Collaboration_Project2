package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.User;

public interface UserDAO {

	
	public List<User> list();
	public User getUser(int id);
	public User save(User user);
	public boolean update(User user);
	public boolean delete(User user);
	
	public boolean validate(String id,String password);
	
	
}
