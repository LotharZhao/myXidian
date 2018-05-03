package com.zhao.vv.thread.b;

/**
 * 持有对象的锁会锁住所有同步方法
 * A线程持有对象的Lock锁，B线程可以以异步方式调用对象中的非synchronized类型的方法
 * A线程持有对象的Lock锁，B线程如果在这时调用对象中的synchronized类型的方法则需要等待，也就是同步
 * @author zhaoliangtao
 *
 */
class Domain2 {
	public synchronized void methodA() {
		try {
			System.out.println("A1-" + Thread.currentThread().getName());
			Thread.sleep(1000);
			System.out.println("A2-" + Thread.currentThread().getName() + " end:" + System.currentTimeMillis());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void methodB() {
		try {
			System.out.println("B1-" + Thread.currentThread().getName() + " begin:" + System.currentTimeMillis());
			Thread.sleep(1000);
			System.out.println("B2-" + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class MyThread2_1 extends Thread {
	private Domain2 d;

	public MyThread2_1(Domain2 d) {
		this.d = d;
	}

	public void run() {
		d.methodA();
	}
}

class MyThread2_2 extends Thread {
	private Domain2 d;

	public MyThread2_2(Domain2 d) {
		this.d = d;
	}

	public void run() {
		d.methodB();
	}
}

public class SynTest2 {
	public static void main(String[] args) {
		Domain2 d = new Domain2();
		MyThread2_1 mt0 = new MyThread2_1(d);
		mt0.setName("mt0");
		MyThread2_2 mt1 = new MyThread2_2(d);
		mt1.setName("mt1");
		mt0.start();
		mt1.start();
	}
}
