package com.ordinap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ordinap.dao.CommentDao;
import com.ordinap.entity.Comment;
import com.ordinap.entity.Post;
import com.ordinap.entity.User;

@Transactional
@Service
public class CommentServiceImp implements CommentService {

	@Autowired
	CommentDao commentDao;
	
	@Override
	public void add(User user, Post post, Comment comment) {

			commentDao.add(user, post, comment);
	}

	@Override
	public Comment get(Integer id) {
		
			return commentDao.get(id);
	}

	@Override
	public List<Comment> getAll() {
		
			return commentDao.getAll();
	}

	@Override
	public List<Comment> getFindByPost(Integer postId, Integer start, Integer rowCount) {
		
		return commentDao.getFindByPost(postId, start, rowCount);
	}

	@Override
	public List<Comment> getFindByUser(Integer userId, Integer start, Integer rowCount) {

			return commentDao.getFindByUser(userId, start, rowCount);
	}

	@Override
	public void delete(Comment comment) {
		
			commentDao.delete(comment);
	}

	@Override
	public Long countByPost() {
	
	return	commentDao.countByPost();
	}

}
