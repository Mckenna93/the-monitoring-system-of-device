package com.ruyi.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.ruyi.domain.User;


public class LoginVerificationInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		String method = invocation.getProxy().getMethod();
		if("login".equals(method)){
			return invocation.invoke();
		}
		User user = (User) invocation.getInvocationContext().getSession().get("user");
		if(user == null){
			return "input";
		}else{
			return invocation.invoke();
		}
	
	}

}
