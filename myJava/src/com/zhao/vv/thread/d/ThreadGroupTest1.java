package com.zhao.vv.thread.d;

/**
 * �߳���
 * �������������̻߳��߳��������Ч�ض��̻߳��߳�����������֯
 * �̹߳����߳��飺1���������Ǹ����������Ӷ��󣬵��������������
 * ThreadGroup(String name)
 * ��������ڿ����кܳ��������紴��һЩ�߳�ʱ��Ϊ����Ч����Щ�߳̽�����ֹ����ͨ��������Ǵ���һ���߳��飬Ȼ���ٽ������̹߳����������У��Դ�������ɢ���̶߳��������Ч�Ĺ���
 * 
 * �̹߳����߳��飺�༶�������Ǹ����������Ӷ����Ӷ������ٴ����Ӷ�����Ҳ�ͳ����������Ч��
 * ThreadGroup(ThreadGroup parent, String name)
 * 
 * �̱߳�����������ܹ鵽ָ���߳�����
 * @author zhaoliangtao
 *
 */
public class ThreadGroupTest1 {
	public static void main(String[] args) {
		dThread1 mt0 = new dThread1();
		dThread1 mt1 = new dThread1();
		ThreadGroup tg = new ThreadGroup("�߳���1");
		Thread t0 = new Thread(tg, mt0);
		Thread t1 = new Thread(tg, mt1);
		t0.start();
		t1.start();
		System.out.println("����߳���Ϊ��" + tg.activeCount());
		System.out.println("�߳��������Ϊ��" + tg.getName());
	}
}

class dThread1 implements Runnable {
	public void run() {
		try {
			while (!Thread.currentThread().isInterrupted()) {
				System.out.println(Thread.currentThread().getName());
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}