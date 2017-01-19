package com.ordinap.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ordinap.entity.User;

public interface UserDao {
	
	public void setSessionFactory(SessionFactory sessionFactory);
	public Session getCurrentSession();
	public void add(User user);
	public User get(int id);
	public List<User> all();
	public void update(User user);
}
