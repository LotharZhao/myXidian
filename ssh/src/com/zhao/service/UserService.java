package com.zhao.service;

import org.springframework.transaction.annotation.Transactional;

import com.zhao.dao.UserDao;

@Transactional
public class UserService {

	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	// ×¢Èëdao
	public void add() {
		System.out.println("service add...");
		userDao.add();
	}

	public void select() {
		System.out.println("service select...");
		userDao.select();
	}

	public void findAll() {
		System.out.println("service findAll...");
		userDao.findAll();
	}

	public void findByName() {
		System.out.println("service findByName...");
		userDao.findByName();
	}
}
