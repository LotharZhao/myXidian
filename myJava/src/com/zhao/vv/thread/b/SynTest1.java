package com.zhao.vv.thread.b;

/**
 * 脏读，多线程对同一个对象的实例变量进行并发操作会引发问题
 * synchronized取得的锁都是"对象"的锁，而不是把一段代码或方法（函数）当作锁
 * 哪个线程先执行带synchronized关键字的方法，哪个线程就持有该方法所属对象的锁
 * @author zhaoliangtao
 *
 */
class Domain1 {
	private int num = 0;

	// 方法加上synchronized可加锁
	public synchronized void addNum(String userName) {
		try {
			if ("a".equals(userName)) {
				num = 100;
				System.out.println("a set over!");
				Thread.sleep(200);
			} else {
				num = 200;
				System.out.println("b set over!");
			}
			System.out.println(userName + " num = " + num);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class MyThread1_1 extends Thread {
	private Domain1 d;

	public MyThread1_1(Domain1 d) {
		this.d = d;
	}

	public void run() {
		d.addNum("a");
	}
}

class MyThread1_2 extends Thread {
	private Domain1 d;

	public MyThread1_2(Domain1 d) {
		this.d = d;
	}

	public void run() {
		d.addNum("b");
	}
}

public class SynTest1 {
	public static void main(String[] args) {
		Domain1 d = new Domain1();
		Domain1 d2 = new Domain1();
		MyThread1_1 mt0 = new MyThread1_1(d);
//		MyThread2 mt1 = new MyThread2(d);
		// 访问两个不同的对象不会冲突，多个线程访问的必须是同一个对象
		MyThread1_2 mt1 = new MyThread1_2(d2);
		mt0.start();
		mt1.start();
	}
}
