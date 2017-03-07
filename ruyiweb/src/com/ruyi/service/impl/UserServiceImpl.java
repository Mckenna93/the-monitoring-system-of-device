package com.ruyi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.ruyi.dao.UserDao;
import com.ruyi.domain.User;
import com.ruyi.service.UserService;

@Component("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;
	
	public User login(User user) {
		// TODO Auto-generated method stub
		return userDao.findByNameAndPwd(user);
		
	}
	
	public boolean changePwd(User user,String newPwd,String oldPwd,String confirmedPwd) {
		// TODO Auto-generated method stub
		if(oldPwd==null || "".equals(oldPwd.trim()) || newPwd==null
				|| confirmedPwd == null|| user==null ||"".equals(newPwd.trim()) 
				|| !newPwd.equals(confirmedPwd) || !oldPwd.equals(user.getPassword())){
			return false;
		}
		user.setPassword(newPwd);
		userDao.updateUser(user);
		return true;
	}

	public List<User> userList() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}

	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		userDao.deleteUser(id);
	}

	public boolean register(User user,String confirmedPwd) {
		// TODO Auto-generated method stub
		if(user==null || user.getUserName()==null || "".equals(user.getUserName().trim())
				 || user.getPassword()==null|| "".equals(user.getPassword().trim()) 
				 || confirmedPwd == null || !confirmedPwd.equals(user.getPassword())){
			return false;
		}
		userDao.addUser(user);
		return true;
	}

}
