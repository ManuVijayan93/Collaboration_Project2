package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.Blog;

public interface BlogDAO 
	{
		public List<Blog> list();
		public boolean save(Blog blog);
		public boolean update(Blog blog);
		public boolean delete(Blog blog);
		public Blog getBlogByID(int id);
		public Blog getBlogByName(String name);
	}


