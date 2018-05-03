package com.zhao.vv.thread.a;

/**
 * 继承Thread类
 * 本质上Thread类也是实现了 Runnable接口的一个实例
 * @author zhaoliangtao
 *
 */
class ThreadDemo extends Thread {
	private Thread t;
	private String threadName;

	ThreadDemo(String name) {
		threadName = name;
		System.out.println("Creating " + threadName);
	}

	// 重写run()方法
	public void run() {
		System.out.println("Running " + threadName);
		for (int i = 1; i < 6; i++) {
			System.out.println("Thread: " + threadName + ", " + i);
		}
		System.out.println("Thread " + threadName + " exiting.");
	}

	public void start() {
		System.out.println("Starting " + threadName);
		if (t == null) {
			t = new Thread(this, threadName);
			t.start();
		}
	}
}

public class ThreadTest {
	public static void main(String args[]) {
		ThreadDemo T1 = new ThreadDemo("Thread-1");
		T1.start();

		ThreadDemo T2 = new ThreadDemo("Thread-2");
		T2.start();

		for (int i = 1; i < 6; i++) {
			System.out.println(Thread.currentThread().getName() + "在运行-" + i);
		}
	}
}