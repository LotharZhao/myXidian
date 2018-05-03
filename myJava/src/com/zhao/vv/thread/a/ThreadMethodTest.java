package com.zhao.vv.thread.a;

/**
 * Thread���е�ʵ������
 * @author zhaoliangtao
 *
 */
class ThreadMethod extends Thread {
	public void run() {
		// Thread.currentThread().XXX()����ִ�и÷������ڴ������߳�
		// getName()
		// getId()ȫ��Ψһ���߳�ID������threadSeqNumber���ɵ�id
		System.out.println(
				Thread.currentThread().getName() + ":" + Thread.currentThread().getId() + ":" + this.getPriority());
		System.out.println(this.getName() + " run = " + this.isAlive());
	}
}

public class ThreadMethodTest {
	public static void main(String[] args) throws Exception {
		ThreadMethod tm0 = new ThreadMethod();

		ThreadMethod tm1 = new ThreadMethod();
		ThreadMethod tm2 = new ThreadMethod();

		// isAlive()�߳��Ƿ��ڻ״̬��ֻҪ�߳�������û����ֹ���������صľ���true
		System.out.println(Thread.currentThread().getName() + " begin == " + tm0.isAlive());
		tm0.start();
		tm1.start();
		tm2.start();

		System.out.println(Thread.currentThread().getName() + " middle == " + tm0.isAlive());
		Thread.sleep(50);
		System.out.println(Thread.currentThread().getName() + " end == " + tm0.isAlive());

		Thread.sleep(100);
		System.out.println("###########");

		// getPriority()��ȡ�̵߳����ȼ���Ĭ��Ϊ5
		System.out.println("main thread begin, priority = " + Thread.currentThread().getPriority());

		ThreadMethod tm3 = new ThreadMethod();
		ThreadMethod tm4 = new ThreadMethod();
		// setPriority()�����̵߳����ȼ���CPU��"����"��ִ����Դ�ø����ȼ��Ƚϸߵ��߳�
		tm3.setPriority(2);
		tm4.setPriority(5);
		tm3.start();
		tm4.start();

		Thread.sleep(100);
		System.out.println("###########");

		ThreadMethod2 mt = new ThreadMethod2();
		// setDaemon(true)����Ϊ�ػ��̣߳�Ч�����Ǻ�������Ҫ�ظ����м���
		mt.setDaemon(true);
		mt.start();
		Thread.sleep(50);
		System.out.println("main���������ˣ�");
	}
}

class ThreadMethod2 extends Thread {
	private int i = 0;
	public void run() {
		try {
			while (true) {
				i++;
				System.out.println("�ػ��߳�i = " + i);
				Thread.sleep(10);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
