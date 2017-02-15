package com.ordinap.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ordinap.entity.Comment;
import com.ordinap.entity.Complaint;
import com.ordinap.entity.Post;
import com.ordinap.entity.User;

@Transactional
@Repository
public class ComplaintDaoImp implements ComplaintDao {

	
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
	public void add(User user, Post post, Comment comment,Complaint complaint) {

		Session session=getCurrentSession();
		complaint.setPost(post);
		complaint.setUser(user);
		complaint.setComment(comment);
		session.persist(comment);
	}

	@Override
	public Complaint get(Integer id) {
		
		Session session=getCurrentSession();
		return session.get(Complaint.class, id);
		
	}

	@Override
	public List<Complaint> getAll() {
		Session session=getCurrentSession();
		TypedQuery<Complaint> query=session.createQuery("from Complaint",Complaint.class);
		return query.getResultList();
	}

	@Override
	public List<Complaint> getAllForPost(Integer postId, Integer start, Integer rowCount) {
		
		Session session=getCurrentSession();
		TypedQuery<Complaint> query=session.createQuery("from Complaint c where postId="+postId,Complaint.class);
		return query.getResultList();
 
	}

	@Override
	public List<Complaint> getAllForComment(Integer commentId, Integer start, Integer rowCount) {

		Session session=getCurrentSession();
		TypedQuery<Complaint> query=session.createQuery("from Complaint c where commentId="+commentId,Complaint.class);
		return query.getResultList();
 

	}

	@Override
	public void delete(Complaint complaint) {
		
		Session session=getCurrentSession();
		session.delete(complaint);

		
	}

	@Override
	public Long countByPost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long countByComment() {
		// TODO Auto-generated method stub
		return null;
	}

}
