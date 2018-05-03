package com.zhao.vv.thread.d;

/**
 * 生产者消费者模型：wait()/notify()
 * 一种重要的模型，基于等待/通知机制。生产者/消费者模型描述的是有一块缓冲区作为仓库，生产者可将产品放入仓库，消费者可以从仓库中取出产品。
 * 生产者生产的时候消费者不能消费，消费者消费的时候生产者不能生产，缓冲区空时消费者不能消费，缓冲区满时生产者不能生产
 * 优点：解耦；通过平衡生产者和消费者的处理能力来提高整体处理数据的速度。
 * 生产者/消费者模型最终达到的目的是平衡生产者和消费者的处理能力。
 * @author zhaoliangtao
 *
 */
public class ModelTest1 {
	public static void main(String[] args) {
		Object lock = new Object();
		final Producer producer = new Producer(lock);
		final Customer customer = new Customer(lock);
		Thread producerThread = new Thread() {
			@Override
			public void run() {
				while (true) {
					producer.setValue();
				}
			}
		};
		Thread CustomerThread = new Thread() {
			@Override
			public void run() {
				while (true) {
					customer.getValue();
				}
			}
		};
		producerThread.start();
		CustomerThread.start();
	}
}

class ValueObject {
	public static String value = "";
}

class Producer {
	private Object lock;

	public Producer(Object lock) {
		this.lock = lock;
	}

	public void setValue() {
		try {
			synchronized (lock) {
				if (!ValueObject.value.equals(""))
					lock.wait();
				String value = System.currentTimeMillis() + "_" + System.nanoTime();
				System.out.println("Set的值是：" + value);
				ValueObject.value = value;
				lock.notify();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Customer {
	private Object lock;

	public Customer(Object lock) {
		this.lock = lock;
	}

	public void getValue() {
		try {
			synchronized (lock) {
				if (ValueObject.value.equals(""))
					lock.wait();
				System.out.println("Get的值是：" + ValueObject.value);
				ValueObject.value = "";
				lock.notify();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}