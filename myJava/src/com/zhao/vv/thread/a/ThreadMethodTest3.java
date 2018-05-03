package com.zhao.vv.thread.a;

/**
 * 中断机制是一种协作机制，也就是说通过中断并不能直接终止另一个线程，而需要被中断的线程自己处理
 * 每个线程对象里都有一个标识位表示是否有中断请求（虚拟机线程实现层面的），代表着是否有中断请求
 * 
 * interrupt()方法的作用仅仅是设置中断标识位，并不能中断线程的运行
 * isInterrupted()唯一的作用只是测试线程是否已经中断，中断标识位的状态并不受到该方法的影响
 * interrupted()作用是测试当前线程是否已经中断，线程的中断标识位由该方法清除
 * @author zhaoliangtao
 *
 */
public class ThreadMethodTest3 {
	public static void main(String[] args) throws InterruptedException {
		Runnable runnable = new Runnable() {
			public void run() {
				while (true) {
					if (Thread.currentThread().isInterrupted()) {
						System.out.println("线程被中断了");
						return;// 如果中断标识为true，结束线程
					} else {
						System.out.println("线程没有被中断");
					}
				}
			}
		};
		Thread t = new Thread(runnable);
		t.start();
		Thread.sleep(3000);
		t.interrupt();
		System.out.println("线程中断了，程序到这里了");
	}
}
