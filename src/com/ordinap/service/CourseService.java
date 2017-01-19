package com.ordinap.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ordinap.entity.Course;

public interface CourseService {

	
	
	public void add(Course course);
	public Course get(int id);
	public List<Course> all();
	public List<Course> all(int start,int rowCount);
	public void update(Course course);
	public void delete(Course course);
}
