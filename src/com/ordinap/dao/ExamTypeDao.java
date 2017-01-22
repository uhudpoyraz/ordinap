package com.ordinap.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ordinap.entity.ExamType;

public interface ExamTypeDao {
	
	public void setSessionFactory(SessionFactory sessionFactory);
	public Session getCurrentSession();
	public void add(ExamType examType);
	public ExamType get(int id);
	public List<ExamType> all();
	public List<ExamType> all(Integer start,Integer rowCount);
	public void update(ExamType examType);
	public void delete(ExamType examType);
	public Long count();

}
