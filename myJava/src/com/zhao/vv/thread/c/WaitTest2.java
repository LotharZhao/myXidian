package com.zhao.vv.thread.c;

/**
 * interrupt()���������ò����ж��̣߳��������߳�������ʱ����߳�һ���жϱ�ʶ����ʾ���߳��ж�
 * wait()����"������һ�ֳ���"
 * @author zhaoliangtao
 *
 */
class Domain {
	public void testMethod(Object lock) {
		try {
			synchronized (lock) {
				System.out.println("Begin wait()");
				lock.wait();
				System.out.println("End wait()");
			}
		} catch (InterruptedException e) {
			System.out.println("wait()��interrupt()����ˣ�");
			e.printStackTrace();
		}
		System.out.println("����ִ��...");
	}
}

class Thread2 extends Thread {
	private Object lock;

	public Thread2(Object lock) {
		this.lock = lock;
	}

	public void run() {
		Domain td = new Domain();
		td.testMethod(lock);
	}
}

public class WaitTest2 {
	public static void main(String[] args) throws Exception {
		Object lock = new Object();
		Thread2 mt = new Thread2(lock);
		mt.start();
		Thread.sleep(1000);
		mt.interrupt();
	}
}
