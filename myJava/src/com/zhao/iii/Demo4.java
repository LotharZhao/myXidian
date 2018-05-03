/**
 * ·ºÐÍ
 */
package com.zhao.iii;

import java.util.ArrayList;

public class Demo4 {
	public static void main(String[] args) {
		ArrayList<Dog> al = new ArrayList<Dog>();

		Dog dog1 = new Dog();
		al.add(dog1);

		Dog temp = al.get(0);
	}
}

class Cat {
	private String color;
	private int age;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}

class Dog {
	private String name;
	private int age;

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
}