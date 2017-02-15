package com.ordinap.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ordinap.entity.Comment;
import com.ordinap.entity.Post;
import com.ordinap.entity.User;

@Repository
public class CommentDaoImp implements CommentDao {

	
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
	public void add(User user, Post post, Comment comment) {
			
		Session session=this.getCurrentSession();
		comment.setUser(user);
		comment.setPost(post);
		session.persist(comment);
		
	}

	@Override
	public Comment get(Integer id) {
		
		Session session=getCurrentSession();
		return session.get(Comment.class, id);
	}

	@Override
	public List<Comment> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Comment> getFindByPost(Integer postId, Integer start, Integer rowCount) {
		Session session=getCurrentSession();
		TypedQuery<Comment> query=session.createQuery("from Comment c INNER JOIN Post p on c.postId=p.id where postId="+postId,Comment.class);
	
		return query.getResultList();
	}

	@Override
	public List<Comment> getFindByUser(Integer userId, Integer start, Integer rowCount) {
		Session session=getCurrentSession();
		TypedQuery<Comment> query=session.createQuery("from Comment c INNER JOIN Post p on c.postId=p.id where userId="+userId,Comment.class);
	
		return query.getResultList();
	}

	@Override
	public void delete(Comment comment) {
		Session session=getCurrentSession();
		session.delete(comment);
	}

	@Override
	public Long countByPost() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
