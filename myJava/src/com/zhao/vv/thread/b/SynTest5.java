package com.zhao.vv.thread.b;

/**
 * 当A线程访问对象的synchronized代码块的时候，B线程依然可以访问对象方法中其余非synchronized块的部分
 * 当A线程进入对象的synchronized代码块的时候，B线程如果要访问这段synchronized块，那么访问将会被阻塞
 * @author zhaoliangtao
 *
 */
class Domain5 {
	public void doLongTimeTask() throws Exception {
		for (int i = 0; i < 10; i++) {
			System.out.println("no -" + Thread.currentThread().getName() + ", i = " + (i + 1));
		}
		System.out.println();
		synchronized (this) {
			for (int i = 0; i < 10; i++) {
				System.out
						.println("syn-" + Thread.currentThread().getName() + ", i = " + (i + 1));
			}
		}
	}
}

class MyThread5 extends Thread {
	private Domain5 d;

	public MyThread5(Domain5 d) {
		this.d = d;
	}

	public void run() {
		try {
			d.doLongTimeTask();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

public class SynTest5 {
	public static void main(String[] args) {
		Domain5 d = new Domain5();
		MyThread5 mt0 = new MyThread5(d);
		MyThread5 mt1 = new MyThread5(d);
		mt0.start();
		mt1.start();
	}
}
