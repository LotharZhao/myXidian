package com.zhao.day2.anno;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhao.day2.xmlanno.BookService;

public class TestAnno {

	@Test
	public void testService2(){
		ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
		BookService service = (BookService) context.getBean("bookService");
		service.add();
	}
	
	@Test
	public void testService(){
		ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
		UserService userService = (UserService) context.getBean("userService");
		userService.add();
	}

	@Test
	public void testUser(){
		ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
		User user = (User) context.getBean("user");
		User user2 = (User) context.getBean("user");
		System.out.println(user);
		System.out.println(user2);
		user.add();
	}
}
