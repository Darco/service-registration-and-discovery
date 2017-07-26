package com.gio.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gio.model.user.User;
import com.gio.user.dao.UserDao;
import com.gio.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Override
	public void addUser(User user) {	
		userDao.addUser(user);
	}

	@Override
	public void deleteUser(Integer id) {
		userDao.deleteUser(id);
	}

	@Override
	public List<User> listUser() {
		return userDao.listUser();
	}

	@Override
	public void update(User user){
		int index = userDao.listUser().indexOf(user);
		userDao.listUser().set(index, user);
	}
	
	@Override
	public User getUserById(Integer id) {
		return userDao.getUserById(id);
	}
	
	@Override
	public User findByName(String name) {
		for(User user : userDao.listUser()){
			if(user.getName().equalsIgnoreCase(name)){
				return user;
			}
		}
		return null;
	}
	
	@Override
	public boolean isUserExist(User user) {
		return findByName(user.getName())!=null;
	}
	
	@Override
	public User findById(Integer id) {
		for(User user : userDao.listUser()){
			if(user.getId() == id){
				return user;
			}
		}
		return null;
	}
}
