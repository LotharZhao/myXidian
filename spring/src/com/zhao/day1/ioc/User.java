package com.zhao.day1.ioc;

public class User {

	private String username;
	private String password;

	public User(String usernname,String password) {
		this.username = usernname;
		this.password = password;
	}

	public void show() {
		System.out.println("username:"+username+" password:"+password);
	}
}
