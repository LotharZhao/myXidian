package com.zhao.vv.collections.iterator;

import java.util.Collection;
import java.util.HashSet;

public class ForeachTest {
	public static void main(String[] args) {
		// ����һ������
		Collection books = new HashSet();
		books.add(new String("������Java EE��ҵӦ��ʵս"));
		books.add(new String("���Java����"));
		books.add(new String("���Android����"));

		for (Object obj : books) {
			// �˴���book����Ҳ���Ǽ���Ԫ�ر���
			String book = (String) obj;
			System.out.println(book);
			if (book.equals("���Android����")) {
				// ������������ConcurrentModificationException�쳣
				// books.remove(book);
			}
		}
		System.out.println(books);
	}
}