package com.zhao.vv.collections.map;

import java.util.IdentityHashMap;

public class IdentityHashMapTest {
	public static void main(String[] args) {
		IdentityHashMap ihm = new IdentityHashMap();
		// �������д��뽫����IdentityHashMap�������������key-value��
		ihm.put(new String("����"), 89);
		ihm.put(new String("����"), 78);

		// �������д���ֻ����IdentityHashMap���������һ��key-value��
		ihm.put("java", 93);
		ihm.put("java", 98);
		System.out.println(ihm);
	}
}