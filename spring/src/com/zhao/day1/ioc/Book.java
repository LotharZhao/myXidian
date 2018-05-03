package com.zhao.day1.ioc;

public class Book {

	private String name;

	public void setName(String name) {
		this.name = name;
	}

	public void show() {
		System.out.println("BookName:" + name);
	}
}
