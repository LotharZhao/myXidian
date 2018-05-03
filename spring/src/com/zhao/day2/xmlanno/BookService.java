package com.zhao.day2.xmlanno;

import javax.annotation.Resource;

public class BookService {
	
	@Resource(name="bookDao")
	private BookDao bookDao;
	
	@Resource(name="ordersDao")
	private OrdersDao ordersDao;

	public void add(){
		System.out.println("service...");
		
		bookDao.book();
		ordersDao.buy();
	}
}
