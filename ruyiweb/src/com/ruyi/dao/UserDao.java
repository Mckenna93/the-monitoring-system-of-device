package com.ruyi.dao;

import java.util.List;

import com.ruyi.domain.User;

public interface UserDao {
	public User findByNameAndPwd(User user);
	public void updateUser(User user);
	public List<User> findAll();
	public void deleteUser(int id);
	public void addUser(User user);

}
