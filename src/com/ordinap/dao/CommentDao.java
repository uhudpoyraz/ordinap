package com.ordinap.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ordinap.entity.Comment;
import com.ordinap.entity.Post;
import com.ordinap.entity.User;

public interface CommentDao {

	
	public void setSessionFactory(SessionFactory sessionFactory);
	public Session getCurrentSession();
	public void add(User user,Post post,Comment comment);
	public Comment get(Integer id);
	public List<Comment> getAll();
	public List<Comment> getFindByPost(Integer postId,Integer start,Integer rowCount);
	public List<Comment> getFindByUser(Integer userId,Integer start,Integer rowCount);
	public void delete(Comment comment);
	public Long countByPost();
	
}
