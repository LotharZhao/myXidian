package com.zhao.vv.thread.b;

/**
 * synchronized������
 * ��һ���̵߳õ�һ�����������ٴ�����˶�����ʱ�ǿ����ٴεõ��ö��������
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
