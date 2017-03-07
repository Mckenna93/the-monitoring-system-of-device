package com.ruyi.test;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ruyi.test.domain.Person;

public class TestMerge {
	
	ClassPathXmlApplicationContext context;
	
	@Before
	public void beforeTest(){
		context = new ClassPathXmlApplicationContext("bean.xml");
	}
	
	@Test
	public void testSpring(){
		TestService testService = (TestService) context.getBean("testService");
		testService.say();
	}
	
	@Test
	public void testSH(){
		SessionFactory sessionFac = (SessionFactory) context.getBean("sessionFactory");
		Session session = sessionFac.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(new Person("test2"));
		transaction.commit();
		session.close();
	}

}
