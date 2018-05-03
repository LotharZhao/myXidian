package com.zhao.vv.thread.d;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者消费者模型：await()/signal()
 * @author zhaoliangtao
 *
 */
public class ModelTest2 {
	public static void main(String[] args) {
		final Domain1 td = new Domain1();
		Runnable producerRunnable = new Runnable() {
			public void run() {
				for (int i = 0; i < Integer.MAX_VALUE; i++)
					td.set();
			}
		};
		Runnable customerRunnable = new Runnable() {
			public void run() {
				for (int i = 0; i < Integer.MAX_VALUE; i++)
					td.get();
			}
		};
		Thread ProducerThread = new Thread(producerRunnable);
		ProducerThread.setName("Producer");
		Thread ConsumerThread = new Thread(customerRunnable);
		ConsumerThread.setName("Consumer");

		ProducerThread.start();
		ConsumerThread.start();
	}
}

class ValueObject2 {
	public static String value = "";
}

class Domain1 extends ReentrantLock {
	private Condition condition = newCondition();

	public void set() {
		try {
			lock();
			while (!"".equals(ValueObject2.value))
				condition.await();
			ValueObject2.value = "11";
			System.out.println(Thread.currentThread().getName() + "生产了value, value的当前值是" + ValueObject2.value);
			condition.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			unlock();
		}
	}

	public void get() {
		try {
			lock();
			while ("".equals(ValueObject2.value))
				condition.await();
			ValueObject2.value = "";
			System.out.println(Thread.currentThread().getName() + "消费了value, value的当前值是" + ValueObject2.value);
			condition.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			unlock();
		}
	}
}