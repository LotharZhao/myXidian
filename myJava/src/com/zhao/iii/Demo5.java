/**
 * ����-->�������
 */
package com.zhao.iii;

import java.lang.reflect.Method;

public class Demo5 {
	public static void main(String[] args) {
		Dog dog = new Dog();
		Gen<Dog> g1 = new Gen<Dog>(dog);
		g1.showTypeName();
	}
}

class Gen<T> {
	private T o;

	public Gen(T a) {
		o = a;
	}

	public void showTypeName() {
		System.out.println("�����ǣ�" + o.getClass().getName());

		Method[] m = o.getClass().getDeclaredMethods();
		for (int i = 0; i < m.length; i++) {
			System.out.println(m[i].getName());
		}
	}
}