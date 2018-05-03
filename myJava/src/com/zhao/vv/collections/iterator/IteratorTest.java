package com.zhao.vv.collections.iterator;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class IteratorTest {
	public static void main(String[] args) {
		// ����һ������
		Collection books = new HashSet();
		books.add("������Java EE��ҵӦ��ʵս");
		books.add("���Java����");
		books.add("���Android����");

		// ��ȡbooks���϶�Ӧ�ĵ�����
		Iterator it = books.iterator();
		while (it.hasNext()) {
			// it.next()�������ص�����������Object���ͣ�
			// ��Ҫǿ������ת��
			String book = (String) it.next();
			System.out.println(book);
			if (book.equals("���Java����")) {
				// �Ӽ�����ɾ����һ��next�������ص�Ԫ��
				it.remove();
			}
			// ��book������ֵ������ı伯��Ԫ�ر���
			book = "�����ַ���";
		}
		System.out.println(books);
	}
}