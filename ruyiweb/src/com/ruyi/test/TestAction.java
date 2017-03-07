package com.ruyi.test;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;


public class TestAction extends ActionSupport{
	
	@Resource
	TestService testService;
	
	public String struts(){
		testService.say();
		return SUCCESS;
	}

}
