package com.zhao.vv.thread.c;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * await()�̹߳����ͷ�����signal()/signalAll()���������߳�
 * ����Ҫ��lock()�������ʹ�������finally��unlock()�ͷ���
 * @author zhaoliangtao
 *
 */
class Domain3 {
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();

	public void await22() {
		try {
			lock.lock();
			System.out.println("awaitʱ��Ϊ��" + System.currentTimeMillis());
			condition.await();
			System.out.println("await�ȴ�����");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void signal22() {
		try {
			lock.lock();
			System.out.println("signalʱ��Ϊ��" + System.currentTimeMillis());
			condition.signal();
		} finally {
			lock.unlock();
		}
	}
}

class MyThread3 extends Thread {
	private Domain3 td;

	public MyThread3(Domain3 td) {
		this.td = td;
	}

	public void run() {
		td.await22();
	}
}

public class LockTest3 {
	public static void main(String[] args) throws Exception {
		Domain3 td = new Domain3();
		MyThread3 mt = new MyThread3(td);
		mt.start();
		Thread.sleep(1000);
		td.signal22();
	}
}
