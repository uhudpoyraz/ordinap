package com.ordinap.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ordinap.entity.User;


@Repository
public class UserDaoImp implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		
		this.sessionFactory=sessionFactory;
		
	}

	@Override
	public Session getCurrentSession() {
		

		return sessionFactory.getCurrentSession();
	}
	@Override
	public void add(User user) {
		
		Session session=getCurrentSession();
		session.persist(user);
	}

	@Override
	public User get(int id) {
		Session session=getCurrentSession();
		User user=session.get(User.class, id);
	
		return user;	
	}

	@Override
	public List<User> all() {
		Session session=getCurrentSession();
		TypedQuery<User> query = session.createQuery("from User", User.class);
		
		return query.getResultList();
	}

	@Override
	public void update(User user) {
		Session session=getCurrentSession();
		session.update(user);

	}

	@Override
	public Long getCountByEmailAndPassword(String email, String password) {
		Session session=getCurrentSession();

		Long rowCount = session.createQuery(
			    "select count(u.id ) " +
			    "from User u where u.email="+email+" and u.password="+password, Long.class )
			.getSingleResult();	
		return rowCount;
	}

	@Override
	public User getByEmailAndPassword(String email, String password) {
		Session session=getCurrentSession();
		User  user = session.createQuery("from User u where u.email='"+email+"' and u.password='"+password+"'", User.class).getSingleResult();
		
		return user;
	}

	
	

}
