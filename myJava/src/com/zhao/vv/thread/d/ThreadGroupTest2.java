package com.zhao.vv.thread.d;

/**
 * �Զ���������˼�����Զ��鵽��ǰ�߳�����
 * û��ָ���߳��飬��ô�Զ��鵽��ǰ�߳��������߳�����
 * @author zhaoliangtao
 *
 */
public class ThreadGroupTest2 {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("A���̣߳�" + Thread.currentThread().getName() + ", �����̣߳�"
				+ Thread.currentThread().getThreadGroup().getName() + ", �������߳���������"
				+ Thread.currentThread().getThreadGroup().activeGroupCount());
		ThreadGroup group = new ThreadGroup("�µ���");
		System.out.println("B���̣߳�" + Thread.currentThread().getName() + ", �����̣߳�"
				+ Thread.currentThread().getThreadGroup().getName() + ", �������߳���������"
				+ Thread.currentThread().getThreadGroup().activeGroupCount());
		ThreadGroup[] tg = new ThreadGroup[Thread.currentThread().getThreadGroup().activeGroupCount()];
		Thread.currentThread().getThreadGroup().enumerate(tg);
		for (int i = 0; i < tg.length; i++)
			System.out.println("��һ���߳�������Ϊ��" + tg[i].getName());

		// ���߳�����ϵͳ�߳���system
		try {
			System.out.println(Thread.currentThread().getThreadGroup().getParent().getName());
			System.out.println(Thread.currentThread().getThreadGroup().getParent().getParent().getName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		ThreadGroup tg2 = new ThreadGroup("����ֹͣ�����߳�");
		dThread2 mt = null;
		for (int i = 0; i < 3; i++) {
			mt = new dThread2(tg2, "�߳�" + i);
			mt.start();
		}
		Thread.sleep(5000);
		// ����ֹͣ�����߳�
		tg2.interrupt();
		System.out.println("������interrupt()����");
	}
}

class dThread2 extends Thread {
	public dThread2(ThreadGroup tg, String name) {
		super(tg, name);
	}

	public void run() {
		System.out.println(Thread.currentThread().getName() + "׼����ʼ��ѭ����");
		while (!this.isInterrupted()) {
		}
		System.out.println(Thread.currentThread().getName() + "������");
	}
}
