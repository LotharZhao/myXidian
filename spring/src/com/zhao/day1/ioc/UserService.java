package com.zhao.day1.ioc;

public class UserService {

	//1����dao��������
	private UserDao userDao;
	//2����set����
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	private UserDao userDao2;
	public void setUserDao2(UserDao userDao2) {
		this.userDao2 = userDao2;
	}
	
	public void add() {
		System.out.println("service...");
		
		userDao.add();
		userDao2.add();
	}
}
