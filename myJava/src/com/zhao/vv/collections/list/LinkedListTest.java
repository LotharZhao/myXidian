package com.zhao.vv.collections.list;

import java.util.LinkedList;

public class LinkedListTest {
	public static void main(String[] args) {
		LinkedList books = new LinkedList();

		// ���ַ���Ԫ�ؼ�����е�β��(˫�˶���)
		books.offer("���Java����");

		// ��һ���ַ���Ԫ�ؼ���ջ�Ķ���(˫�˶���)
		books.push("������Java EE��ҵӦ��ʵս");

		// ���ַ���Ԫ����ӵ����е�ͷ(�൱��ջ�Ķ���)
		books.offerFirst("���Android����");

		for (int i = 0; i < books.size(); i++) {
			System.out.println(books.get(i));
		}

		// ���ʡ�����ɾ��ջ����Ԫ��
		System.out.println(books.peekFirst());
		// ���ʡ�����ɾ�����е����һ��Ԫ��
		System.out.println(books.peekLast());
		// ��ջ����Ԫ�ص���"ջ"
		System.out.println(books.pop());
		// ������������������е�һ��Ԫ�ر�ɾ��
		System.out.println(books);
		// ���ʡ���ɾ�����е����һ��Ԫ��
		System.out.println(books.pollLast());
		// �������������������ֻʣ���м�һ��Ԫ�أ�
		// ������Java EE��ҵӦ��ʵս
		System.out.println(books);
	}
}