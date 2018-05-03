package com.zhao.day1.ioc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIOC {
	
	@Test
	public void testPerson2(){
		ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
		Person person= (Person) context.getBean("person2");
		person.test2();
	}
	
	@Test
	public void testPerson(){
		ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
		Person person= (Person) context.getBean("person");
		person.test1();
	}
	
	@Test
	public void testService(){
		ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
		UserService service = (UserService) context.getBean("userService");
		service.add();
	}
	
	@Test
	public void testBook(){
		ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
		Book book = (Book) context.getBean("book");
		book.show();
	}
	
	@Test
	public void testUser(){
		// 1����spring�����ļ������������ļ���������
		ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
		// 2�õ����ô����Ķ���
		User user1 = (User) context.getBean("user");
		User user2 = (User) context.getBean("user");
		System.out.println(user1);
		System.out.println(user2);
		user1.show();
		user2.show();
	}
}
