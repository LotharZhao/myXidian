package com.zhao.vv.thread.a;

/**
 * �̳�Thread��
 * ������Thread��Ҳ��ʵ���� Runnable�ӿڵ�һ��ʵ��
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

	// ��дrun()����
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
			System.out.println(Thread.currentThread().getName() + "������-" + i);
		}
	}
}