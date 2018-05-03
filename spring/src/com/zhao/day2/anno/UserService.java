package com.zhao.day2.anno;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService {
	
	//得到dao对象
//	@Autowired
//	private UserDao userDao;
	
	@Resource(name="userDao123")
	private UserDao userDao;
	
	public void add() {
		System.out.println("service...");
		
		userDao.add();
	}
}
