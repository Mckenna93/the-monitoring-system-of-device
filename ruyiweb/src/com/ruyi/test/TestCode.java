package com.ruyi.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ruyi.domain.Repair;
import com.ruyi.domain.Warning;
import com.ruyi.service.RepairService;
import com.ruyi.service.WarningService;

public class TestCode {
	
ClassPathXmlApplicationContext context;
	
	@Before
	public void beforeTest(){
		context = new ClassPathXmlApplicationContext("bean.xml");
	}
	
	@Test
	//�������ݿ�������������
	public void testCode(){
		RepairService repairService = (RepairService) context.getBean("repairService");
		Repair repair = repairService.findByNumber(25);
		System.out.println("find");
	}
	
	//���Զ���ֶ�ӳ��һ������
	@Test
	public void testWarning(){
		WarningService warningService = (WarningService) context.getBean("warningService");
		List<Warning> warning = warningService.findByDeviceid("200000000000");
		System.out.println("find warning");
	}
	
	//����һ��ʵ�����Ӧ���ű�
	@Test
	public void testWarn(){
		WarningService warningService = (WarningService) context.getBean("warningService");
		List<Warning> warning = warningService.findByDeviceid("200000000000");
		System.out.println("find warn");
			
	}
	
	

}
