/**
 * 集合ArrayList
 */
package com.zhao.iii;

import java.util.*;

public class Demo1 {
	public static void main(String[] args) {
		// 定义ArrayList对象
		ArrayList al = new ArrayList();
		System.out.println(al.size());// al的大小

		// 向al中加入数据（类型是Object）
		Clerk c1 = new Clerk("aa", 40, 1000);
		Clerk c2 = new Clerk("bb", 30, 1200);
		Clerk c3 = new Clerk("cc", 24, 500);
		al.add(c1);
		al.add(c2);
		al.add(0, c3);
		System.out.println(al.size());
		al.remove(2);
		System.out.println(al.size());

		for (int i = 0; i < al.size(); i++) {
			Clerk temp = (Clerk) al.get(i);
			System.out.println(temp.getName() + "+" + temp.getAge() + "+"
					+ temp.getSalary());
		}

	}
}

class Clerk {
	private String name;
	private int age;
	private float salary;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public Clerk(String name, int age, float salary) {
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
}