package com.zhao.vv.thread.b;

/**
 * 静态同步方法和非静态同步方法持有的是不同的锁，前者是类锁，后者是对象锁
 * @author zhaoliangtao
 *
 */
class Domain7 {
	public synchronized static void printA() {
		try {
			System.out.println(Thread.currentThread().getName() + "-A-begin-" + System.currentTimeMillis());
			Thread.sleep(100);
			System.out.println(Thread.currentThread().getName() + "-A-end-" + System.currentTimeMillis());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized static void printB() {
		System.out.println(Thread.currentThread().getName() + "-B-begin-" + System.currentTimeMillis());
		System.out.println(Thread.currentThread().getName() + "-B-end-" + System.currentTimeMillis());

	}

	public synchronized void printC() {
		System.out.println(Thread.currentThread().getName() + "-C-begin-" + System.currentTimeMillis());
		System.out.println(Thread.currentThread().getName() + "-C-end-" + System.currentTimeMillis());
	}
}

class MyThread7_1 extends Thread {
	public void run() {
		Domain7.printA();
	}
}

class MyThread7_2 extends Thread {
	public void run() {
		Domain7.printB();
	}
}

class MyThread7_3 extends Thread {
	private Domain7 d;

	public MyThread7_3(Domain7 d) {
		this.d = d;
	}

	public void run() {
		d.printC();
	}
}

public class SynTest7 {
	public static void main(String[] args) {
		Domain7 d = new Domain7();
		MyThread7_1 mt0 = new MyThread7_1();
		MyThread7_2 mt1 = new MyThread7_2();
		MyThread7_3 mt2 = new MyThread7_3(d);
		mt0.start();
		mt1.start();
		mt2.start();
	}
}
