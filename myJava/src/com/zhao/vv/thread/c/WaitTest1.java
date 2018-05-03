package com.zhao.vv.thread.c;

/**
 * wait()��������ʹ���ø��̵߳ķ����ͷŹ�����Դ������Ȼ�������״̬�˳�������ȴ����У�ֱ���ٴα�����
 * notify()��������������ѵȴ������еȴ�ͬһ������Դ��һ���̣߳���ʹ�ø��߳��˳��ȴ�״̬�����������״̬
 * notifyAll()��������ʹ�������ڵȴ������еȴ�ͬһ������Դ��ȫ���̴߳ӵȴ�״̬�˳������������״̬ 
 * wait()������notify()/notifyAll()����������ͬ������/ͬ��������б�����
 * @author zhaoliangtao
 *
 */
class Thread1_1 extends Thread {
	private Object lock;

	public Thread1_1(Object lock) {
		this.lock = lock;
	}

	public void run() {
		try {
			synchronized (lock) {
				System.out.println("��ʼ---wait time = " + System.currentTimeMillis());
				lock.wait();
				System.out.println("����---wait time = " + System.currentTimeMillis());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Thread1_2 extends Thread {
	private Object lock;

	public Thread1_2(Object lock) {
		this.lock = lock;
	}

	public void run() {
		synchronized (lock) {
			System.out.println("��ʼ---notify time = " + System.currentTimeMillis());
//			lock.notify();
			lock.notifyAll();
			System.out.println("����---notify time = " + System.currentTimeMillis());
		}
	}
}

public class WaitTest1 {
	public static void main(String[] args) throws Exception {
		Object lock = new Object();
		Thread1_1 mt0_1 = new Thread1_1(lock);
		Thread1_1 mt0_2 = new Thread1_1(lock);
		Thread1_1 mt0_3 = new Thread1_1(lock);
		mt0_1.start();
		mt0_2.start();
		mt0_3.start();
		Thread.sleep(3000);
		Thread1_2 mt1 = new Thread1_2(lock);
		mt1.start();
	}
}
