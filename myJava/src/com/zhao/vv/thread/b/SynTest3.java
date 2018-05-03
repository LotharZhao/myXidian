package com.zhao.vv.thread.b;

/**
 * synchronized锁重入
 * 当一个线程得到一个对象锁后，再次请求此对象锁时是可以再次得到该对象的锁的
 * @author zhaoliangtao
 *
 */
class Domain3 {
	public synchronized void print1() {
		System.out.println("Domain3.print1()");
		print2();
	}

	public synchronized void print2() {
		System.out.println("Domain3.print2()");
		print3();
	}

	public synchronized void print3() {
		System.out.println("Domain3.print3()");
	}
}

class MyThread3 extends Thread {
	public void run() {
		Domain3 td = new Domain3();
		td.print1();
	}
}

public class SynTest3 {
	public static void main(String[] args) {
		MyThread3 mt = new MyThread3();
		mt.start();
	}
}
