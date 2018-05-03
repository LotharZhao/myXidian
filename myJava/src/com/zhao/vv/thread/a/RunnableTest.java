package com.zhao.vv.thread.a;

/**
 * 实现Runnable接口
 * @author zhaoliangtao
 *
 */
class RunnableDemo implements Runnable {
	private Thread t;
	private String threadName;

	RunnableDemo(String name) {
		threadName = name;
		System.out.println("Creating " + threadName);
	}

	// 实现run()方法
	public void run() {
		System.out.println("Running " + threadName);
		try {
			for (int i = 1; i < 6; i++) {
				System.out.println("Thread: " + threadName + ", " + i);
				// 让线程睡眠一会,单位ms
				Thread.sleep(50);
			}
		} catch (InterruptedException e) {
			System.out.println("Thread " + threadName + " interrupted.");
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

public class RunnableTest {
	public static void main(String args[]) throws InterruptedException {
		RunnableDemo R1 = new RunnableDemo("Thread-1");
		R1.start();

		RunnableDemo R2 = new RunnableDemo("Thread-2");
		R2.start();

		for (int i = 1; i < 6; i++) {
			System.out.println(Thread.currentThread().getName() + "在运行-" + i);
			Thread.sleep(50);
		}
	}
}