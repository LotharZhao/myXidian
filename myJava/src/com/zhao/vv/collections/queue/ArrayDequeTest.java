package com.zhao.vv.collections.queue;

import java.util.ArrayDeque;

public class ArrayDequeTest {
	public static void main(String[] args) {
		ArrayDeque stack = new ArrayDeque();
		// ���ν�����Ԫ��push��"ջ"
		stack.push("���Java����");
		stack.push("������Java EE��ҵӦ��ʵս");
		stack.push("���Android����");

		// �����[���Android����, ������Java EE��ҵӦ��ʵս, ���Java����]
		System.out.println(stack);

		// ���ʵ�һ��Ԫ�أ�����������pop��"ջ"����������Android����
		System.out.println(stack.peek());

		// ��Ȼ�����[���Android����, ������Java EE��ҵӦ��ʵս, ���Java����]
		System.out.println(stack);

		// pop����һ��Ԫ�أ���������Android����
		System.out.println(stack.pop());

		// �����[������Java EE��ҵӦ��ʵս, ���Java����]
		System.out.println(stack);
	}
}
