package com.ruyi.test;

import org.springframework.stereotype.Service;

@Service("testService")

public class TestServiceImpl implements TestService {

	public void say() {
		// TODO Auto-generated method stub
		System.out.println("hello,service");

	}

}
