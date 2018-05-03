package com.zhao.car;

import java.util.ArrayList;

// 用arraylist模拟一个内存数据库
public class DB {
	private static ArrayList al = null;

	private DB() {
	}

	static {
		al = new ArrayList<Book>();
		Book book1 = new Book();
		book1.setId("1");
		book1.setName("java");
		book1.setPrice(11);

		Book book2 = new Book();
		book2.setId("2");
		book2.setName("c");
		book1.setPrice(6);

		Book book3 = new Book();
		book3.setId("3");
		book3.setName("php");
		book1.setPrice(13);

		al.add(book1);
		al.add(book2);
		al.add(book3);
	}

	public static ArrayList getDB() {
		return al;
	}

	public static Book getBookById(String id) {
		Book book = null;
		boolean b = false;
		for (int i = 0; i < al.size(); i++) {
			book = (Book) al.get(i);
			if (book.getId().equals(id)) {
				b = true;
				break;
			}
		}
		if (b) {
			return book;
		} else {
			return null;
		}
	}
}
