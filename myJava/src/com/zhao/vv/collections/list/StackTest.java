package com.zhao.vv.collections.list;

import java.util.Stack;

public class StackTest {
	public static void main(String[] args) {
		Stack v = new Stack();
		// ���ν�����Ԫ��push��"ջ"
		v.push("���Java����");
		v.push("������Java EE��ҵӦ��ʵս");
		v.push("���Android����");

		// �����[���Java����, ������Java EE��ҵӦ��ʵս , ���Android����]
		System.out.println(v);

		// ���ʵ�һ��Ԫ�أ�����������pop��"ջ"����������Android����
		System.out.println(v.peek());

		// ��Ȼ�����[���Java����, ������Java EE��ҵӦ��ʵս , ���Android����]
		System.out.println(v);

		// pop����һ��Ԫ�أ���������Android����
		System.out.println(v.pop());

		// �����[���Java����, ������Java EE��ҵӦ��ʵս]
		System.out.println(v);
	}
}
