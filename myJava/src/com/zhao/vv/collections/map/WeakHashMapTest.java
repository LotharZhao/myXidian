package com.zhao.vv.collections.map;

import java.util.WeakHashMap;

public class WeakHashMapTest {
	public static void main(String[] args) {
		WeakHashMap whm = new WeakHashMap();
		// ��WeakHashMap���������key-value�ԣ�
		// ����key���������ַ�������û���������ã�
		whm.put(new String("����"), new String("����"));
		whm.put(new String("��ѧ"), new String("����"));
		whm.put(new String("Ӣ��"), new String("�е�"));

		// ��WeakHashMap�����һ��key-value�ԣ�
		// ��key��һ��ϵͳ������ַ�������"java"��һ�������ַ���ǿ����
		whm.put("java", new String("�е�"));
		// ���whm���󣬽�����4��key-value�ԡ�
		System.out.println(whm);
		// ֪ͨϵͳ����������������
		System.gc();
		System.runFinalization();
		// ͨ������£���ֻ����һ��key-value�ԡ�
		System.out.println(whm);
	}
}