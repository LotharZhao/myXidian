package com.zhao.vv.collections.map;

import java.util.Hashtable;

class A {
	int count;

	public A(int count) {
		this.count = count;
	}

	// ����count��ֵ���ж����������Ƿ���ȡ�
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (obj != null && obj.getClass() == A.class) {
			A a = (A) obj;
			return this.count == a.count;
		}
		return false;
	}

	// ����count������hashCodeֵ��
	public int hashCode() {
		return this.count;
	}
}

class B {
	// ��дequals()������B�������κζ���ͨ��equals()�����Ƚ϶����
	public boolean equals(Object obj) {
		return true;
	}
}

public class HashtableTest {
	public static void main(String[] args) {
		Hashtable ht = new Hashtable();
		ht.put(new A(60000), "���Java����");
		ht.put(new A(87563), "������Java EE��ҵӦ��ʵս");
		ht.put(new A(1232), new B());
		System.out.println(ht);

		// ֻҪ��������ͨ��equals�ȽϷ���true��
		// Hashtable����Ϊ��������ȵ�value��
		// ����Hashtable����һ��B����
		// �����κζ���ͨ��equals�Ƚ϶���ȣ������������true��
		System.out.println(ht.containsValue("�����ַ���")); // ��

		// ֻҪ����A�����count��ȣ�����ͨ��equals�ȽϷ���true����hashCode���
		// Hashtable����Ϊ��������ͬ��key�������������true��
		System.out.println(ht.containsKey(new A(87563))); // ��

		// ����������ɾ�����һ��key-value��
		ht.remove(new A(1232)); // ��

		// ͨ������Hashtable������key��ɵ�Set���ϣ�
		// �Ӷ�����Hashtableÿ��key-value��
		for (Object key : ht.keySet()) {
			System.out.print(key + "---->");
			System.out.print(ht.get(key) + "\n");
		}
	}
}