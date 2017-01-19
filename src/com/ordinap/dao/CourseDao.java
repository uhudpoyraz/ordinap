package com.ordinap.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ordinap.entity.Course;

 
public interface CourseDao {
	
	public void setSessionFactory(SessionFactory sessionFactory);
	public Session getCurrentSession();
	public void add(Course course);
	public Course get(int id);
	public List<Course> all();
	public List<Course> all(int start,int rowCount);
	public void update(Course course);
	public void delete(Course course);

}
