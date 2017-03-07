package com.ruyi.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ruyi.domain.User;
import com.ruyi.service.UserService;

@Component("userAction")
public class UserAction extends ActionSupport implements ModelDriven<User>{

	private User user = new User();
	private String oldPwd;
	private String newPwd;
	private String confirmedPwd;
	@Resource
	private UserService userService;
	
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
	
	public String getOldPwd() {
		return oldPwd;
	}

	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}

	public String getNewPwd() {
		return newPwd;
	}

	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}
	
	public String getConfirmedPwd() {
		return confirmedPwd;
	}

	public void setConfirmedPwd(String confirmedPwd) {
		this.confirmedPwd = confirmedPwd;
	}
	
	//µÇÂ¼,²»±»À¹½ØÆ÷À¹½Ø
	public String login(){
		User loginUser = userService.login(user);
		if(loginUser==null){
			return INPUT;
		}else{
			ActionContext ac = ActionContext.getContext();
			ac.getSession().put("user", loginUser);
			return SUCCESS;
		}
	}
	
	//ÍË³öÏµÍ³
	public String logout(){
		ActionContext ac = ActionContext.getContext();
		ac.getSession().put("user", null);
		return INPUT;
	}
	

	public String changePwd(){
		return "changepassword";
	}
	
	public String changePassword(){
		ActionContext ac = ActionContext.getContext();
		User user = (User) ac.getSession().get("user");
		if(userService.changePwd(user, newPwd, oldPwd, confirmedPwd)){
			return "changesuccess";
		}else{
			return "changefail";
		}
		
	}

}
