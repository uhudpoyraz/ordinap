package com.ordinap.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ordinap.entity.Comment;
import com.ordinap.entity.Complaint;
import com.ordinap.entity.Post;
import com.ordinap.entity.User;

public interface ComplaintDao {
	
	public void setSessionFactory(SessionFactory sessionFactory);
	public Session getCurrentSession();
	public void add(User user, Post post, Comment comment,Complaint complaint);
	public Complaint get(Integer id);
	public List<Complaint> getAll();
	public List<Complaint> getAllForPost(Integer postId,Integer start,Integer rowCount);
	public List<Complaint> getAllForComment(Integer commentId,Integer start,Integer rowCount);
	public void delete(Complaint complaint);
	public Long countByPost();
	public Long countByComment();

}
