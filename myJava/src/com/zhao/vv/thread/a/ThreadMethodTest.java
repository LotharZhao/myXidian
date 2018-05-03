package com.zhao.vv.thread.a;

/**
 * Thread类中的实例方法
 * @author zhaoliangtao
 *
 */
class ThreadMethod extends Thread {
	public void run() {
		// Thread.currentThread().XXX()正在执行该方法所在代码块的线程
		// getName()
		// getId()全局唯一的线程ID生成器threadSeqNumber生成的id
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

		// isAlive()线程是否处于活动状态，只要线程启动且没有终止，方法返回的就是true
		System.out.println(Thread.currentThread().getName() + " begin == " + tm0.isAlive());
		tm0.start();
		tm1.start();
		tm2.start();

		System.out.println(Thread.currentThread().getName() + " middle == " + tm0.isAlive());
		Thread.sleep(50);
		System.out.println(Thread.currentThread().getName() + " end == " + tm0.isAlive());

		Thread.sleep(100);
		System.out.println("###########");

		// getPriority()获取线程的优先级，默认为5
		System.out.println("main thread begin, priority = " + Thread.currentThread().getPriority());

		ThreadMethod tm3 = new ThreadMethod();
		ThreadMethod tm4 = new ThreadMethod();
		// setPriority()设置线程的优先级，CPU会"尽量"将执行资源让给优先级比较高的线程
		tm3.setPriority(2);
		tm4.setPriority(5);
		tm3.start();
		tm4.start();

		Thread.sleep(100);
		System.out.println("###########");

		ThreadMethod2 mt = new ThreadMethod2();
		// setDaemon(true)设置为守护线程，效果不是很明显需要重复运行几次
		mt.setDaemon(true);
		mt.start();
		Thread.sleep(50);
		System.out.println("main结束运行了！");
	}
}

class ThreadMethod2 extends Thread {
	private int i = 0;
	public void run() {
		try {
			while (true) {
				i++;
				System.out.println("守护线程i = " + i);
				Thread.sleep(10);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
