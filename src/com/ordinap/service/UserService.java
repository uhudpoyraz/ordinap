package com.ordinap.service;

import java.util.List;

import com.ordinap.dao.UserDao;
import com.ordinap.entity.User;

public interface UserService {
	
	
	public void add(User user);
	public User get(int id);
	public List<User> all();
	public void update(User user);

}
