package com.zhao.vv.thread.c;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock和synchronized持有的对象监视器不同 ReentrantLock持有的锁是需要手动去unlock()的
 * 
 * @author zhaoliangtao
 *
 */
class Domain2 {
	private Lock lock = new ReentrantLock();

	public void methodA() {
		try {
			lock.lock();
			System.out.println("A begin " + Thread.currentThread().getName());
			Thread.sleep(1000);
			System.out.println("A end " + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void methodB() {
		lock.lock();
		System.out.println("B begin " + Thread.currentThread().getName());
		System.out.println("B begin " + Thread.currentThread().getName());
		lock.unlock();
	}

	public synchronized void methodC() {
		try {
			System.out.println("C begin " + Thread.currentThread().getName());
			Thread.sleep(1000);
			System.out.println("C begin " + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class MyThread2_1 extends Thread {
	private Domain2 td;

	public MyThread2_1(Domain2 td) {
		this.td = td;
	}

	public void run() {
		td.methodA();
	}
}

class MyThread2_2 extends Thread {
	private Domain2 td;

	public MyThread2_2(Domain2 td) {
		this.td = td;
	}

	public void run() {
		td.methodB();
	}
}

class MyThread2_3 extends Thread {
	private Domain2 td;

	public MyThread2_3(Domain2 td) {
		this.td = td;
	}

	public void run() {
		td.methodC();
	}
}

public class LockTest2 {
	public static void main(String[] args) {
		Domain2 td = new Domain2();
		MyThread2_1 mt0 = new MyThread2_1(td);
		MyThread2_2 mt1 = new MyThread2_2(td);
		MyThread2_3 mt2 = new MyThread2_3(td);
		mt0.start();
		mt1.start();
		mt2.start();
	}
}
