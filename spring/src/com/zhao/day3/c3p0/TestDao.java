package com.zhao.day3.c3p0;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDao {
	
	@Test
	public void testDao() {
		ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
		UserService userService= (UserService) context.getBean("userService");
		userService.add();
	}
}
