package com.ordinap.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
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
	public User getByEmailAndPassword(String email, String password) {
		Session session=getCurrentSession();
 	 CriteriaBuilder builder = session.getCriteriaBuilder();

	        //Create Criteria
	        CriteriaQuery<User> criteria = builder.createQuery(User.class);
	        Root<User> userRoot = criteria.from(User.class);
	        criteria.multiselect(userRoot.get("id"),
	        		userRoot.get("name"),
	        		userRoot.get("surname"),
	        		userRoot.get("email"),
	        		userRoot.get("profileImage"),
	        		userRoot.get("token"));
	        criteria.where(builder.equal(userRoot.get("email"), email),builder.equal(userRoot.get("password"),password));
 	        User user = session.createQuery(criteria).getSingleResult();
 
		
		return user;
	}

	
	

}
