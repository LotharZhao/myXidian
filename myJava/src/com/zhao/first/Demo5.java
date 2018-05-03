/*
作者：
功能：this的必要性
日期：2016/11/16
*/
package com.zhao.first;
public class Demo5
{
	public static void main(String[] args) 
	{
		/*
		Dog dog1 = new Dog(2,"do");

		Person p1 = new Person(dog1,22,"na");
		Person p2 = new Person(dog1,22,"la");
		p1.showInfo();
		p1.dog.showInfo();

		Child ch1 = new Child(3,"ca");
		ch1.joinGame();
		Child ch2 = new Child(5,"sa");
		ch2.joinGame();
		Child ch3 = new Child(5,"dd");
		ch3.joinGame();
		System.out.println("共有："+Child.total);
		*/
		Clerk c1 = new Clerk("cc",20,3000f);
		System.out.println(c1.name+"+"+c1.getSal());
	}
}

class Clerk
{
	public String name;
	private int age;
	private float salary;

	public Clerk(String name,int age,float sal){
		this.name = name;
		this.age = age;
		this.salary = sal;
	}

	public float getSal(){
		return this.salary;
	}
}

class Child
{
	int age;
	String name;
	static int total = 0;
	public Child(int age,String name){
		this.age = age;
		this.name = name;
	}

	public void joinGame(){
		System.out.println("加入"+name);
		total++;
	}
}

class Person
{
	int age;
	String name;
	Dog dog;//引用类型

	public Person(Dog dog,int age,String name){
		this.dog = dog;
		this.age = age;
		this.name = name;
	}

	//显示人的名字
	public void showInfo(){
		System.out.println("人名是："+this.name);
	}
}

class Dog
{
	int age;
	String name;

	public Dog(int age,String name){
		this.age = age;
		this.name = name;
	}

	public void showInfo(){
		System.out.println("狗名是："+this.name);
	}
}