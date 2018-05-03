/**
 * ���߳�2
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

// ��Ʊ������
class TicketWindow implements Runnable {
	private int nums = 500;// ��Ʊ��

	@Override
	public void run() {
		while (true) {
			// ��֤��ԭ���ԣ�ͬ�������
			synchronized (this) {
				if (nums > 0) {
					System.out.println(Thread.currentThread().getName() + "�۳���"
							+ nums + "��Ʊ");
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