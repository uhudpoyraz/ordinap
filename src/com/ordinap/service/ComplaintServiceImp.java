package com.ordinap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordinap.dao.ComplaintDao;
import com.ordinap.entity.Comment;
import com.ordinap.entity.Complaint;
import com.ordinap.entity.Post;
import com.ordinap.entity.User;

@Service
public class ComplaintServiceImp implements ComplaintService {

	@Autowired
	ComplaintDao complaintDao;
	
	@Override
	public void add(User user, Post post, Comment comment, Complaint complaint) {

		complaintDao.add(user, post, comment, complaint);

	}

	@Override
	public Complaint get(Integer id) {
		

		return complaintDao.get(id);
	}

	@Override
	public List<Complaint> getAll() {
	
		return complaintDao.getAll();
		
	}

	@Override
	public List<Complaint> getAllForPost(Integer postId, Integer start, Integer rowCount) {

		return complaintDao.getAllForPost(postId, start, rowCount);
	}

	@Override
	public List<Complaint> getAllForComment(Integer commentId, Integer start, Integer rowCount) {
		return complaintDao.getAllForComment(commentId, start, rowCount);
	}

	@Override
	public void delete(Complaint complaint) {
		
		complaintDao.delete(complaint);
	}

	@Override
	public Long countByPost() {

	 return complaintDao.countByPost();
	}

	@Override
	public Long countByComment() {
		
		return complaintDao.countByComment();

	}

}
