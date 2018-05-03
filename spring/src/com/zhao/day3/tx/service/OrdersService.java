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
	 * ҵ���߼��㣬����dao�ķ���
	 */
	public void accountMoney() {
		// q��500
		ordersDao.lessMoney();

		// �쳣
		int i = 10 / 0;

		// w��500
		ordersDao.moreMoney();
	}
}
