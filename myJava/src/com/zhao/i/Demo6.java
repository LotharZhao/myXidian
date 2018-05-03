/**
 * final
 */
package com.zhao.i;

public class Demo6 {
	public static void main(String[] args) {
		Aaa aaa = new Aaa();
		Bbb bbb = new Bbb();
		aaa.show();
		bbb.show();
	}
}

final class Aa {

}

class Aaa {
	int a = 0;
	final float rate = 3.1415926f;

	final public void sendMes() {
		System.out.println("发生消息");
	}

	public void show() {
		System.out.println(a);
	}
}

class Bbb extends Aaa {
	public Bbb() {
		a++;
	}
}

interface Fish2 {
	public void swimming();
}

interface Bird {
	public void fly();
}

class Monkey {
	int name;

	public void jump() {
		System.out.println("跳");
	}
}

class LittleMonkey extends Monkey implements Fish2, Bird {

	@Override
	public void swimming() {
	}

	@Override
	public void fly() {
	}
}