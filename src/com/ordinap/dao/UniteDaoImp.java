package com.ordinap.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ordinap.entity.Unite;

@Repository
public class UniteDaoImp implements UniteDao{

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
	public void add(Unite unite) {
		
		Session session=getCurrentSession();
		session.persist(unite);
		
	}

	@Override
	public Unite get(int id) {
		Session session=getCurrentSession();
		Unite unite=session.get(Unite.class,id);
		return unite;
	}

	@Override
	public List<Unite> all(int id) {
		Session session=getCurrentSession();
		TypedQuery<Unite> query=session.createQuery("from Unite where id="+id,Unite.class);
		return query.getResultList();
	}
	
	@Override
	public List<Unite> all(Integer id,Integer start,Integer rowCount) {
		Session session=getCurrentSession();
		TypedQuery<Unite> query=session.createQuery("from Unite where courseId="+id,Unite.class);
		query.setFirstResult(start);
		query.setMaxResults(rowCount);
		return query.getResultList();
	}

	@Override
	public void update(Unite unite) {
		Session session=getCurrentSession();
		session.update(unite);
		
	}
	
	@Override
	public void delete(Unite unite) {
		Session session=getCurrentSession();
		session.delete(unite);
		
	}
	@Override
	public Long count(int courseId){
		Session session=getCurrentSession();

		Long rowCount = session.createQuery(
			    "select count(u.id ) " +
			    "from Unite u where courseId="+courseId, Long.class )
			.getSingleResult();	
		return rowCount;
	}


}
