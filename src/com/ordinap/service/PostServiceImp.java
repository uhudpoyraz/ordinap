package com.ordinap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ordinap.dao.PostDao;
import com.ordinap.entity.Post;
import com.ordinap.entity.Unite;
import com.ordinap.entity.User;

@Transactional
@Service
public class PostServiceImp implements PostService {

	@Autowired
	PostDao postDao;
	
	@Override
	public void add(User user, Unite unite, Post post) {
		
		postDao.add(user, unite, post);
		
	}

	@Override
	public Post get(Integer postId) {
		
		return postDao.get(postId);
		
	}

	@Override
	public List<Post> getAll() {
		

			return postDao.getAll();
	}

	@Override
	public List<Post> getFindByExamTypeId(Integer examTypeId, Integer start, Integer rowCount) {
		

			return postDao.getFindByExamTypeId(examTypeId, start, rowCount);
	}

	@Override
	public List<Post> getFindByUntieId(Integer uniteId, Integer start, Integer rowCount) {
		
		return postDao.getFindByUntieId(uniteId, start, rowCount);
	}

	@Override
	public void delete(Post post) {
		
		postDao.delete(post);
		
	}

	@Override
	public Long count() {
	
		return postDao.count();
	}

	@Override
	public Long getCountByUser(Long userId) {
		
		return postDao.getCountByUser(userId);
	}

}
