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
	//测试数据库中文乱码问题
	public void testCode(){
		RepairService repairService = (RepairService) context.getBean("repairService");
		Repair repair = repairService.findByNumber(25);
		System.out.println("find");
	}
	
	//测试多个字段映射一个主键
	@Test
	public void testWarning(){
		WarningService warningService = (WarningService) context.getBean("warningService");
		List<Warning> warning = warningService.findByDeviceid("200000000000");
		System.out.println("find warning");
	}
	
	//测试一个实体类对应多张表
	@Test
	public void testWarn(){
		WarningService warningService = (WarningService) context.getBean("warningService");
		List<Warning> warning = warningService.findByDeviceid("200000000000");
		System.out.println("find warn");
			
	}
	
	

}
