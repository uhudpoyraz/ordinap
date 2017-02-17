package com.ordinap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ordinap.dao.UserDao;
import com.ordinap.entity.User;

@Transactional
@Service
public class UserServiceImp implements UserService {


	@Autowired
	UserDao userDao;
	
	@Transactional
	@Override
	public void add(User user) {
		
		userDao.add(user);
		
	}

	@Transactional
	@Override
	public User get(int id) {
		
	return userDao.get(id);
		
	}

	@Transactional
	@Override
	public List<User> all() {

		return userDao.all();

	}

	@Transactional
	@Override
	public void update(User user) {
		userDao.update(user);
		
	}

	@Override
	public User getByEmailAndPassword(String email, String password) {
		return userDao.getByEmailAndPassword(email, password);
	}
 

}
