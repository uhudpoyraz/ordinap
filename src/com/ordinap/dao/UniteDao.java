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
	public List<Unite> all(int id,int start,int rowCount);
	public List<Unite> all(int id);
	public void update(Unite unite);
	public void delete(Unite unite);
	
}
