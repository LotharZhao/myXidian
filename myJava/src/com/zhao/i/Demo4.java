/**
 * ∂‡Ã¨
 */
package com.zhao.i;

public class Demo4 {
	public static void main(String[] args) {
		/*Animal2 an = new Animal2();
		an.cry();

		Cat2 cat = new Cat2();
		cat.cry();
		Dog2 dog = new Dog2();
		dog.cry();

		Animal2 an2 = new Cat2();
		an2.cry();*/

		Master master = new Master();
		master.feed(new Dog2(), new Guto());
		master.feed(new Cat2(), new Fish());
	}
}

class Master {
	// Œπ ≥
	public void feed(Animal2 an, Food f) {
		f.showName();
		an.eat();
	}
}

class Food {
	String name;
	public void showName() {

	}
}

class Fish extends Food {
	public void showName() {
		System.out.println("”„");
	}
}

class Guto extends Food {
	public void showName() {
		System.out.println("π«Õ∑");
	}
}

class Animal2 {
	String name;
	int age;

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

	public void cry() {
		System.out.println("Ω–");
	}

	public void eat() {
		System.out.println("≥‘");
	}
}

class Cat2 extends Animal2 {
	public void cry() {
		System.out.println("ﬂ˜");
	}

	public void eat() {
		System.out.println("≥‘”„");
	}
}

class Dog2 extends Animal2 {
	public void cry() {
		System.out.println("ÕÙ");
	}

	public void eat() {
		System.out.println("≥‘π«Õ∑");
	}
}