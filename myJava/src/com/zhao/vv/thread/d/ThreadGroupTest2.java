package com.zhao.vv.thread.d;

/**
 * 自动归属的意思就是自动归到当前线程组中
 * 没有指定线程组，那么自动归到当前线程所属的线程组中
 * @author zhaoliangtao
 *
 */
public class ThreadGroupTest2 {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("A处线程：" + Thread.currentThread().getName() + ", 所属线程："
				+ Thread.currentThread().getThreadGroup().getName() + ", 组中有线程组数量："
				+ Thread.currentThread().getThreadGroup().activeGroupCount());
		ThreadGroup group = new ThreadGroup("新的组");
		System.out.println("B处线程：" + Thread.currentThread().getName() + ", 所属线程："
				+ Thread.currentThread().getThreadGroup().getName() + ", 组中有线程组数量："
				+ Thread.currentThread().getThreadGroup().activeGroupCount());
		ThreadGroup[] tg = new ThreadGroup[Thread.currentThread().getThreadGroup().activeGroupCount()];
		Thread.currentThread().getThreadGroup().enumerate(tg);
		for (int i = 0; i < tg.length; i++)
			System.out.println("第一个线程组名称为：" + tg[i].getName());

		// 根线程组是系统线程组system
		try {
			System.out.println(Thread.currentThread().getThreadGroup().getParent().getName());
			System.out.println(Thread.currentThread().getThreadGroup().getParent().getParent().getName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		ThreadGroup tg2 = new ThreadGroup("批量停止组内线程");
		dThread2 mt = null;
		for (int i = 0; i < 3; i++) {
			mt = new dThread2(tg2, "线程" + i);
			mt.start();
		}
		Thread.sleep(5000);
		// 批量停止组内线程
		tg2.interrupt();
		System.out.println("调用了interrupt()方法");
	}
}

class dThread2 extends Thread {
	public dThread2(ThreadGroup tg, String name) {
		super(tg, name);
	}

	public void run() {
		System.out.println(Thread.currentThread().getName() + "准备开始死循环了");
		while (!this.isInterrupted()) {
		}
		System.out.println(Thread.currentThread().getName() + "结束了");
	}
}
