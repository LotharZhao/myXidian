package com.zhao.day3.tx.service;

import org.springframework.transaction.annotation.Transactional;

import com.zhao.day3.tx.dao.OrdersDao;

@Transactional
public class OrdersService {

	private OrdersDao ordersDao;

	public void setOrdersDao(OrdersDao ordersDao) {
		this.ordersDao = ordersDao;
	}

	/*
	 * 业务逻辑层，调用dao的方法
	 */
	public void accountMoney() {
		// q少500
		ordersDao.lessMoney();

		// 异常
		int i = 10 / 0;

		// w多500
		ordersDao.moreMoney();
	}
}
