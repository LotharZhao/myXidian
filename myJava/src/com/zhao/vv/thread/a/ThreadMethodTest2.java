package com.zhao.vv.thread.a;

/**
 * Thread���е�ʵ������
 * @author zhaoliangtao
 *
 */
class ThreadStaticMethod extends Thread {
	static {
		// currentThread()�Ե�ǰ����ִ���̶߳��������
		// �߳���Ĺ��췽������̬���Ǳ�main�̵߳��õģ����߳����run()��������Ӧ���߳��Լ����õ�
		System.out.println("��̬��Ĵ�ӡ��" + Thread.currentThread().getName());
	}

	public ThreadStaticMethod() {
		// ��ǰִ�е�Threadδ�ؾ��Ǳ��߳�
		System.out.println("���췽���Ĵ�ӡ��" + Thread.currentThread().getName());
		System.out.println("���췽��this�Ĵ�ӡ��" + this.getName());
	}

	public void run() {
		System.out.println("run()�����Ĵ�ӡ��" + Thread.currentThread().getName());
		try {
			// sleep(1000)��ǰ����ִ�е��߳�����ms
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("run()����this�Ĵ�ӡ��" + this.getName());
	}
}

class ThreadStaticMethod2 extends Thread {
	public void run() {
		long beginTime = System.currentTimeMillis();
		int count = 0;
		for (int i = 0; i < 50000000; i++) {
			// yield()��ͣ��ǰִ�е��̶߳��󣬻����CPU��Դ������CPU��ʱ�䲻ȷ��
			Thread.yield();
			count = count + i + 1;
		}
		long endTime = System.currentTimeMillis();
		System.out.println("��ʱ��" + (endTime - beginTime) + "ms��");
	}
}

public class ThreadMethodTest2 {
	public static void main(String[] args) throws InterruptedException {
		ThreadStaticMethod tsm = new ThreadStaticMethod();
		System.out.println("begin = " + System.currentTimeMillis());
		tsm.start();
		// ��Ϊtsm��main���첽�ģ�����û��sleep()ִ�е�ʱ���
		System.out.println("endxx = " + System.currentTimeMillis());

		ThreadStaticMethod2 tsm2 = new ThreadStaticMethod2();
		tsm2.start();
	}
}
