/**
 * 抽象类、接口
 */
package com.zhao.i;

public class Demo5 {
	public static void main(String[] args) {
		System.out.println(Usb.a);
	}
}

abstract class Animal3 {
	String name;
	int age;

	public abstract void cry();
}

class Cat3 extends Animal3 {
	@Override
	public void cry() {
		System.out.println("喵");
	}
}

interface Usb {
	int a = 100;

	public void start();
	public void stop();
}

interface Kk {}
interface Gg extends Kk{}

class Upan implements Usb, Gg {
	@Override
	public void start() {
		System.out.println("start Upan");
	}

	@Override
	public void stop() {
		System.out.println("stop Upan");
	}
}