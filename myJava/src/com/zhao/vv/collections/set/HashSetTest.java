package com.zhao.vv.collections.set;

import java.util.HashSet;

//��A��equals�������Ƿ���true,��û����д��hashCode()���������ܱ�֤��ǰ������HashSet�е�Ψһ����
class A {
	public boolean equals(Object obj) {
		return true;
	}
}

// ��B��hashCode()�������Ƿ���1,��û����д��equals()���������ܱ�֤��ǰ������HashSet�е�Ψһ����
class B {
	public int hashCode() {
		return 1;
	}
}

// ��C��hashCode()�������Ƿ���2,������д��equals()����
class C {
	public int hashCode() {
		return 2;
	}

	public boolean equals(Object obj) {
		return true;
	}
}

public class HashSetTest {
	public static void main(String[] args) {
		HashSet books = new HashSet();
		// �ֱ���books�������������A��������B��������C����
		books.add(new A());
		books.add(new A());

		books.add(new B());
		books.add(new B());

		books.add(new C());
		books.add(new C());
		System.out.println(books);
	}
}