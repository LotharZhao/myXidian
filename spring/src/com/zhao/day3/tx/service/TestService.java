package com.zhao.day3.tx.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestService {

	@Test
	public void testService() {
		ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
		OrdersService ordersService = (OrdersService) context.getBean("ordersService");
		ordersService.accountMoney();
	}
}
