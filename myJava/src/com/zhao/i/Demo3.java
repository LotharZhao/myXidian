package com.zhao.i;

public class Demo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal an = new Animal();
		an.cry();
		Cat cat1 = new Cat();
		cat1.cry();
		Dog dog1 = new Dog();
		dog1.cry();
	}
}

class Animal {
	int age;
	String name;

	protected void cry() {
		System.out.println("½Ð");
	}
}

class Cat extends Animal {
	public void cry() {
		System.out.println("ß÷");
	}
}

class Dog extends Animal {
	protected void cry() {
		System.out.print("Íô");
		System.out.println("Íô");
	}
}
