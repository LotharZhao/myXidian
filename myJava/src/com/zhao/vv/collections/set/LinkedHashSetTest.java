package com.zhao.vv.collections.set;

import java.util.LinkedHashSet;

public class LinkedHashSetTest {
	public static void main(String[] args) {
		LinkedHashSet books = new LinkedHashSet();
		books.add("Java");
		books.add("LittleHann");
		System.out.println(books);

		// ɾ�� Java
		books.remove("Java");
		// ������� Java
		books.add("Java");
		System.out.println(books);
	}
}