package com.ordinap.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ordinap.entity.Course;
import com.ordinap.entity.Unite;

@Repository
public class CourseImp implements CourseDao{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		
		this.sessionFactory=sessionFactory;
	}

	@Override
	public Session getCurrentSession() {
		 
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void add(Course course) {

		Session session=getCurrentSession();
		session.persist(course);
	}

	@Override
	public Course get(int id) {
		Session session=getCurrentSession();
		Course course=session.get(Course.class, id);
		return course;
		
	}

	@Override
	public List<Course> all() {
		Session session=getCurrentSession();
		TypedQuery<Course> query=session.createQuery("from Course",Course.class);
		return query.getResultList();
	}
	
	@Override
	public List<Course> all(Integer start, Integer rowCount) {
		Session session=getCurrentSession();
		TypedQuery<Course> query=session.createQuery("from Course",Course.class);
		query.setFirstResult(start!=null?start:0);
		query.setMaxResults(rowCount!=null?rowCount:3);
		return query.getResultList();
 	}
	@Override
	public void update(Course course) {
		Session session=getCurrentSession();
		session.update(course);
		
	}

	@Override
	public void delete(Course course) {

		Session session=getCurrentSession();
		session.delete(course);
	}

	@Override
	public Long count(){
		Session session=getCurrentSession();

		Long rowCount = session.createQuery(
			    "select count(c.id ) " +
			    "from Course c ", Long.class )
			.getSingleResult();	
		return rowCount;
	}
 



}
