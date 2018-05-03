package com.zhao.vv.thread.b;

/**
 * synchronized(this)代码块的锁和方法的锁是一样的，是对象锁
 * synchronized(XX)引用的是XX对象的锁，相同对象的锁互斥
 * @author zhaoliangtao
 *
 */
class Domain6 {
	public void serviceMethodA() {
		synchronized (this) {
			try {
				System.out.println("A begin time = " + System.currentTimeMillis());
				Thread.sleep(200);
				System.out.println("A end time = " + System.currentTimeMillis());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

	private Object o = new Object();

	public void serviceMethodB() {
		synchronized (o) {
			try {
				System.out.println("B begin time = " + System.currentTimeMillis());
				Thread.sleep(200);
				System.out.println("B end time = " + System.currentTimeMillis());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	// A、C不会交叉运行
	public synchronized void serviceMethodC() {
		System.out.println("C begin time = " + System.currentTimeMillis());
		System.out.println("C end time = " + System.currentTimeMillis());
	}
}

class Domain6_2 {
	public void serviceMethodB_2(Domain6 d) {
		try {
			// 持有的是Domain6对象的锁，与Domain6中同样持有该锁的方法互斥
			synchronized (d) {
				System.out.println("B_2 begin time = " + System.currentTimeMillis());
				Thread.sleep(200);
				System.out.println("B_2 end time = " + System.currentTimeMillis());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class MyThread6_1 extends Thread {
	private Domain6 td;

	public MyThread6_1(Domain6 td) {
		this.td = td;
	}

	public void run() {
		td.serviceMethodA();
	}
}

class MyThread6_2 extends Thread {
	private Domain6 td;

	public MyThread6_2(Domain6 td) {
		this.td = td;
	}

	public void run() {
		td.serviceMethodB();
	}
}

class MyThread6_3 extends Thread {
	private Domain6 td;

	public MyThread6_3(Domain6 td) {
		this.td = td;
	}

	public void run() {
		td.serviceMethodC();
	}
}

class MyThread6_4 extends Thread {
	private Domain6 d;
	private Domain6_2 d2;

	public MyThread6_4(Domain6 d, Domain6_2 d2) {
		this.d = d;
		this.d2 = d2;
	}

	public void run() {
		d2.serviceMethodB_2(d);
	}
}

public class SynTest6 {
	public static void main(String[] args) {
		Domain6 td = new Domain6();
		Domain6_2 td2 = new Domain6_2();
		MyThread6_1 mt0 = new MyThread6_1(td);
		MyThread6_2 mt1 = new MyThread6_2(td);
		MyThread6_3 mt2 = new MyThread6_3(td);
		MyThread6_4 mt3 = new MyThread6_4(td, td2);
		mt0.start();
		mt1.start();
		mt2.start();
		mt3.start();
	}
}
