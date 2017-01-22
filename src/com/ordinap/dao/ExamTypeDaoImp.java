package com.ordinap.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ordinap.entity.ExamType;

@Transactional
@Repository
public class ExamTypeDaoImp implements ExamTypeDao {

	
	Session session;
	
	@Autowired
	SessionFactory sessionFactory;
	
	 
	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		
		this.sessionFactory=sessionFactory;
		
	}

	@Override
	public Session getCurrentSession() {
			
		return this.sessionFactory.getCurrentSession();

		
	}

	@Override
	public void add(ExamType examType) {
		
		Session session=getCurrentSession();
		session.persist(examType);
	}

	@Override
	public ExamType get(int id) {
		Session session=getCurrentSession();
		return session.get(ExamType.class,id );

	}

	@Override
	public List<ExamType> all() {
		Session session=getCurrentSession();
		TypedQuery<ExamType> query=session.createQuery("from ExamType",ExamType.class);		
		return query.getResultList();
	}

	@Override
	public List<ExamType> all(Integer start, Integer rowCount) {
		Session session=getCurrentSession();
		TypedQuery<ExamType> query=session.createQuery("from ExamType",ExamType.class);		
		query.setMaxResults(rowCount);
		query.setFirstResult(start);

		return query.getResultList();
	}

	@Override
	public void update(ExamType examType) {
		Session session=getCurrentSession();
		session.update(examType);
	}

	@Override
	public void delete(ExamType examType) {
		Session session=getCurrentSession();
		session.delete(examType);
		
	}

	@Override
	public Long count() {
		Session session=getCurrentSession();
		Long rowCount = session.createQuery(
			    "select count(et.id ) " +
			    "from ExamType et ", Long.class )
			.getSingleResult();	
		return rowCount;
	}

}
