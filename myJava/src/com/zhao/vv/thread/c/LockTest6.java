package com.zhao.vv.thread.c;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock�еķ���
 * ʹ�ü̳�ReentrantLock��д��
 * @author zhaoliangtao
 *
 */
class Domain6 extends ReentrantLock {
	public void testMethod() {
		try {
			lock();
			
			// tryLock()�����������ǣ��ڵ���try()������ʱ�������û�б�����һ���̳߳��У���ô�ͷ���true�����򷵻�false
			// tryLock(long timeout, TimeUnit unit)��tryLock()��һ����Ҫ�����ط�������ʾ�����ָ���ȴ�ʱ���ڻ���������򷵻�true�����򷵻�false
			// tryLock()ֻ̽�����Ƿ񣬲�û��lock()�Ĺ���
			if (tryLock())
	            System.out.println(Thread.currentThread().getName() + "�������");
	        else
	            System.out.println(Thread.currentThread().getName() + "û�л����");
			
			
			System.out.println(Thread.currentThread().getName() + "����������");
			// isHeldByCurrentThread()��ʾ�˶���������Ƿ��ɵ�ǰ�̱߳���
			System.out.println(Thread.currentThread().getName() + "�Ƿ��������" + isHeldByCurrentThread());
			// isLocked()��ʾ�˶���������Ƿ��������̱߳���
			System.out.println("�Ƿ������̳߳�������1��" + isLocked());
			Thread.sleep(Integer.MAX_VALUE);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			unlock();
		}
	}

	public void testHoldLock() {
		if (tryLock())
            System.out.println(Thread.currentThread().getName() + "�������");
        else
            System.out.println(Thread.currentThread().getName() + "û�л����");
		
		System.out.println(Thread.currentThread().getName() + "�Ƿ��������" + isHeldByCurrentThread());
		System.out.println("�Ƿ������̳߳�������2��" + isLocked());
	}
}

public class LockTest6 {
	public static void main(String[] args) {
		final Domain6 td = new Domain6();
		Runnable runnable0 = new Runnable() {
			public void run() {
				td.testMethod();
			}
		};
		Runnable runnable1 = new Runnable() {
			public void run() {
				td.testHoldLock();
			}
		};
		Thread t0 = new Thread(runnable0);
		Thread t1 = new Thread(runnable1);
		t0.start();
		t1.start();
	}
	/**
	 * ��������
	 * getWaitQueueLength(Condition condition)
	 ����getQueueLength()�������˷�����ǰ����condition������5���̣߳�ÿ���̶߳�ִ����ͬһ��await()��await()��������ô�������õķ���ֵ��5����Ϊ5���̶߳��ڵȴ������
	 * hasWaiters(Condition condition)
	 ��ѯ�Ƿ����߳����ڵȴ�������йص�condition����������5���̣߳�ÿ���̶߳�ִ����ͬһ��condition��await()��������ô�������õķ���ֵ��true����Ϊ���Ƕ��ڵȴ�condition
	 * lockInterruptibly()
	 �����ǰ�߳�δ���жϣ����ȡ��
	 * getWaitingThreads(Condition condition)
	 ����һ��collection���������������ڵȴ��������ظ�����������Щ�̣߳���Ϊ��������ʱ��ʵ���߳̿��ܶ�̬�仯����˷��ص�collectionֻ�Ǿ����Ĺ���ֵ
	 */
}
