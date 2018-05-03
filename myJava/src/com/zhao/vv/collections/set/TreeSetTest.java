package com.zhao.vv.collections.set;

import java.util.TreeSet;

public class TreeSetTest {
	public static void main(String[] args) {
		TreeSet nums = new TreeSet();
		// ��TreeSet������ĸ�Integer����
		nums.add(5);
		nums.add(2);
		nums.add(10);
		nums.add(-9);

		// �������Ԫ�أ���������Ԫ���Ѿ���������״̬
		System.out.println(nums);

		// ���������ĵ�һ��Ԫ��
		System.out.println(nums.first());

		// �������������һ��Ԫ��
		System.out.println(nums.last());

		// ����С��4���Ӽ���������4
		System.out.println(nums.headSet(4));

		// ���ش���5���Ӽ������Set�а���5���Ӽ��л�����5
		System.out.println(nums.tailSet(5));

		// ���ش��ڵ���-3��С��5���Ӽ���
		System.out.println(nums.subSet(-3, 5));
	}
}