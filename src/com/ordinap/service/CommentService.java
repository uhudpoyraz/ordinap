package com.ordinap.service;

import java.util.List;

import com.ordinap.entity.Comment;
import com.ordinap.entity.Post;
import com.ordinap.entity.User;

public interface CommentService {

	
	public void add(User user,Post post,Comment comment);
	public Comment get(Integer id);
	public List<Comment> getAll();
	public List<Comment> getFindByPost(Integer postId,Integer start,Integer rowCount);
	public List<Comment> getFindByUser(Integer userId,Integer start,Integer rowCount);
	public void delete(Comment comment);
	public Long countByPost();
}
