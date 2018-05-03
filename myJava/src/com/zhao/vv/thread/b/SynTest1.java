package com.zhao.vv.thread.b;

/**
 * ��������̶߳�ͬһ�������ʵ���������в�����������������
 * synchronizedȡ�õ�������"����"�����������ǰ�һ�δ���򷽷���������������
 * �ĸ��߳���ִ�д�synchronized�ؼ��ֵķ������ĸ��߳̾ͳ��и÷��������������
 * @author zhaoliangtao
 *
 */
class Domain1 {
	private int num = 0;

	// ��������synchronized�ɼ���
	public synchronized void addNum(String userName) {
		try {
			if ("a".equals(userName)) {
				num = 100;
				System.out.println("a set over!");
				Thread.sleep(200);
			} else {
				num = 200;
				System.out.println("b set over!");
			}
			System.out.println(userName + " num = " + num);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class MyThread1_1 extends Thread {
	private Domain1 d;

	public MyThread1_1(Domain1 d) {
		this.d = d;
	}

	public void run() {
		d.addNum("a");
	}
}

class MyThread1_2 extends Thread {
	private Domain1 d;

	public MyThread1_2(Domain1 d) {
		this.d = d;
	}

	public void run() {
		d.addNum("b");
	}
}

public class SynTest1 {
	public static void main(String[] args) {
		Domain1 d = new Domain1();
		Domain1 d2 = new Domain1();
		MyThread1_1 mt0 = new MyThread1_1(d);
//		MyThread2 mt1 = new MyThread2(d);
		// ����������ͬ�Ķ��󲻻��ͻ������̷߳��ʵı�����ͬһ������
		MyThread1_2 mt1 = new MyThread1_2(d2);
		mt0.start();
		mt1.start();
	}
}
