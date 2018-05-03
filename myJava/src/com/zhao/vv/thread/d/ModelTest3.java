package com.zhao.vv.thread.d;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
/**
 * 生产者消费者模型：BlockingQueue
 * @author zhaoliangtao
 *
 */
public class ModelTest3 {
	public static void main(String[] args) {
		final BlockingQueue<String> bq = new ArrayBlockingQueue<String>(10);
		Thread producerThread = new Thread() {
			int i = 0;
			@Override
			public void run() {
				while (true) {
					try {
						System.out.println("我生产了一个" + i++);
						bq.put(i + "");
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		Thread customerThread = new Thread() {
			@Override
			public void run() {
				while (true) {
					try {
						System.out.println("我消费了一个" + bq.take());
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		producerThread.start();
		customerThread.start();
	}
}
