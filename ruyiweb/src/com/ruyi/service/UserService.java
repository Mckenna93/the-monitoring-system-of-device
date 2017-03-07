package com.ruyi.service;

import java.util.List;

import com.ruyi.domain.User;

public interface UserService {
	public User login(User user);
	public boolean changePwd(User user,String newPwd,String oldPwd,String confirmedPwd);
	public List<User> userList();
	public void deleteUser(int id);
	public boolean register(User user,String confirmedPwd);

}
