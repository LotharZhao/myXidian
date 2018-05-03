package com.zhao.vv.thread.b;

/**
 * ��A�̷߳��ʶ����synchronized������ʱ��B�߳���Ȼ���Է��ʶ��󷽷��������synchronized��Ĳ���
 * ��A�߳̽�������synchronized������ʱ��B�߳����Ҫ�������synchronized�飬��ô���ʽ��ᱻ����
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
