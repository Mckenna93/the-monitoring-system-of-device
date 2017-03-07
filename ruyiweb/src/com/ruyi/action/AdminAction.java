package com.ruyi.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ruyi.domain.User;
import com.ruyi.service.UserService;

@Component("adminAction")
public class AdminAction extends ActionSupport implements ModelDriven<User>{
	
	@Resource
	private UserService userService;
	private User user = new User();
	private String confirmedPwd;
	
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String getConfirmedPwd() {
		return confirmedPwd;
	}

	public void setConfirmedPwd(String confirmedPwd) {
		this.confirmedPwd = confirmedPwd;
	}
	//先判断用户是否登录再跳转
	public String userList(){
		ActionContext ac = ActionContext.getContext();
		List<User> userList = userService.userList();
		ac.getSession().put("userList", userList);
		return "showlist";
	}
	
	public String deleteUser(){
		//传过来的id被封装在user对象中		
		userService.deleteUser(user.getId());
		return "list";
	}
	
	public String addUser(){
		return "register";
	}
	
	public String register(){
		if(userService.register(user, confirmedPwd)){
			return "list";
		}else{
			return "register";
		}		
		
	}


}
