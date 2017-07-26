package com.gio.user.dao;

import java.util.List;

import com.gio.model.user.User;

public interface UserDao {

	public void addUser(User user);
	public void deleteUser(Integer id);
	public void update(User user);
	public List<User> listUser();
	public User getUserById(Integer id);
}
