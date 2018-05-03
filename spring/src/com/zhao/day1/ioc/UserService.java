package com.zhao.day1.ioc;

public class UserService {

	//1定义dao类型属性
	private UserDao userDao;
	//2生成set方法
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
