/**
 * 多线程2
 */
package com.zhao.vi;

public class Demo4 {
	public static void main(String[] args) {
		Tiger tiger = new Tiger();
//		tiger.start();
		tiger.start();

		Lion lion = new Lion();
		Thread t = new Thread(lion);
//		t.start();
		t.start();

		TicketWindow tw1 = new TicketWindow();
//		TicketWindow tw2 = new TicketWindow();
//		TicketWindow tw3 = new TicketWindow();

		Thread t1 = new Thread(tw1);
		Thread t2 = new Thread(tw1);
		Thread t3 = new Thread(tw1);
		t1.start();
		t2.start();
		t3.start();
	}
}

// 售票窗口类
class TicketWindow implements Runnable {
	private int nums = 500;// 总票数

	@Override
	public void run() {
		while (true) {
			// 保证其原子性，同步代码块
			synchronized (this) {
				if (nums > 0) {
					System.out.println(Thread.currentThread().getName() + "售出第"
							+ nums + "张票");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					nums--;
				} else {
					break;
				}
			}
		}
	}
}

class Tiger extends Thread {
	public void run() {
		System.out.println("tiger");
	}
}

class Lion implements Runnable {

	@Override
	public void run() {
		System.out.println("lion");
	}
}