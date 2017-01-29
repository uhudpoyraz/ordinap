package com.ordinap.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ordinap.entity.Post;
import com.ordinap.entity.Unite;
import com.ordinap.entity.User;

@Repository
public class PostDaoImp implements PostDao{

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
	public void add(User user, Unite unite, Post post) {
		
		
		Session session=getCurrentSession();
		post.setUser(user);
		post.setUnite(unite);
	    session.persist(post);

		
	}

	@Override
	public Post get(Integer postId) {
		
		Session session=getCurrentSession();
		return session.get(Post.class,postId);		
	}

	@Override
	public List<Post> getAll() {
		
		System.out.println("cek");
		Session session=getCurrentSession();
		TypedQuery<Post> query=session.createQuery("from Post",Post.class);
		return query.getResultList();
		
	}

	@Override
	public List<Post> getFindByExamTypeId(Integer examTypeId, Integer start, Integer rowCount) {
		
 		Session session=getCurrentSession();
		TypedQuery<Post> query=session.createQuery("select p from Post p INNER JOIN Unite u on p.unite.id=u.id INNER JOIN UniteToExam ue on ue.uniteId=u.id where ue.examTypeId="+examTypeId,Post.class);
		
		
		return query.getResultList();
	}

	@Override
	public List<Post> getFindByUntieId(Integer uniteId, Integer start, Integer rowCount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Post post) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
