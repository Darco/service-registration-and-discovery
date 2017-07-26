package com.gio.user.service;

import java.util.List;

import com.gio.model.user.User;

public interface UserService {

	public void addUser(User user);
	public void deleteUser(Integer id);
	public List<User> listUser();
	public void update(User user);
	public User getUserById(Integer id);
	public boolean isUserExist(User user);
	User findByName(String name);
	User findById(Integer id);
}
