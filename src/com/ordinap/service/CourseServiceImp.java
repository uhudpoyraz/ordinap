package com.ordinap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ordinap.dao.CourseDao;
import com.ordinap.entity.Course;

@Service
public class CourseServiceImp implements CourseService{

	@Autowired
	CourseDao courseDao;
	

	@Transactional
	@Override
	public void add(Course course) {

		courseDao.add(course);		
	}
	
	@Transactional
	@Override
	public Course get(int id) {
		
		return courseDao.get(id);
	}
	
	@Transactional
	@Override
	public List<Course> all() {
		
		return courseDao.all();
	}
	
	@Transactional
	@Override
	public void update(Course course) {
		
		courseDao.update(course);
	}
	
	@Transactional
	@Override
	public List<Course> all(Integer start, Integer rowCount) {
	
		return courseDao.all(start, rowCount);
	}
	@Transactional
	@Override
	public void delete(Course course) {
		
		courseDao.delete(course);
		
	}
	@Transactional
	@Override
	public Long count(){
		
	return	courseDao.count();
		
	}
}
