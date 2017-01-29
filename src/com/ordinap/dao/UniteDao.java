package com.ordinap.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ordinap.entity.Unite;

public interface UniteDao {

	public void setSessionFactory(SessionFactory sessionFactory);
	public Session getCurrentSession();
	public void add(Unite unite);
	public Unite get(int id);
	public List<Unite> all(Integer id,Integer start,Integer rowCount);
	public List<Unite> all(Integer courseId);
	public List<Unite> all();
	public void update(Unite unite);
	public void delete(Unite unite);
	public Long count(int courseId);
 
 }
