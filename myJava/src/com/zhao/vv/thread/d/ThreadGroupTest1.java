package com.zhao.vv.thread.d;

/**
 * 线程组
 * 可以批量管理线程或线程组对象，有效地对线程或线程组对象进行组织
 * 线程关联线程组：1级关联，是父对象中有子对象，但并不创建孙对象。
 * ThreadGroup(String name)
 * 这种情况在开发中很常见，比如创建一些线程时，为了有效对这些线程进行阻止管理，通常情况下是创建一个线程组，然后再将部分线程归属到该组中，以此来对零散的线程对象进行有效的管理。
 * 
 * 线程关联线程组：多级关联，是父对象中有子对象，子对象中再创建子对象买也就出现了子孙的效果
 * ThreadGroup(ThreadGroup parent, String name)
 * 
 * 线程必须启动后才能归到指定线程组中
 * @author zhaoliangtao
 *
 */
public class ThreadGroupTest1 {
	public static void main(String[] args) {
		dThread1 mt0 = new dThread1();
		dThread1 mt1 = new dThread1();
		ThreadGroup tg = new ThreadGroup("线程组1");
		Thread t0 = new Thread(tg, mt0);
		Thread t1 = new Thread(tg, mt1);
		t0.start();
		t1.start();
		System.out.println("活动的线程数为：" + tg.activeCount());
		System.out.println("线程组的名称为：" + tg.getName());
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