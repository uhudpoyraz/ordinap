package com.ordinap.service;

import java.util.List;

import com.ordinap.entity.Course;

public interface CourseService {

	
	
	public void add(Course course);
	public Course get(int id);
	public List<Course> all();
	public List<Course> all(Integer start,Integer rowCount);
	public void update(Course course);
	public void delete(Course course);
	public Long count(); 
	}
