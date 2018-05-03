package com.zhao.day2.xmlanno;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestXmlAnno {

	@Test
	public void testService(){
		ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
		BookService service = (BookService) context.getBean("bookService");
		service.add();
	}
}
