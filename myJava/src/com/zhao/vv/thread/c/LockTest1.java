package com.zhao.vv.thread.c;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock������Ļ�����
 * ������ʹ��synchronized��������������ʵ���ʽ����������ͬ��һЩ������Ϊ������
 * @author zhaoliangtao
 *
 */
class Domain1 {
	private Lock lock = new ReentrantLock();

	public void testMethod() {
		try {
			lock.lock();
			for (int i = 0; i < 2; i++) {
				System.out.println("ThreadName = " + Thread.currentThread().getName() + ", i  = " + i);
			}
		} finally {
			lock.unlock();
		}
	}
}

class MyThread1 extends Thread {
	private Domain1 d;

	public MyThread1(Domain1 d) {
		this.d = d;
	}

	public void run() {
		d.testMethod();
	}
}

public class LockTest1 {
	public static void main(String[] args) {
		Domain1 td = new Domain1();
		MyThread1 mt0 = new MyThread1(td);
		MyThread1 mt1 = new MyThread1(td);
		MyThread1 mt2 = new MyThread1(td);
		mt0.start();
		mt1.start();
		mt2.start();
	}
}
