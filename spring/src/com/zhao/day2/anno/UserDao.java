package com.zhao.day2.anno;

import org.springframework.stereotype.Component;

@Component(value="userDao123")
public class UserDao {

	public void add() {
		System.out.println("dao...");
	}
}
