package com.zhao.vv.thread.d;

/**
 * ������������ģ�ͣ�wait()/notify()
 * һ����Ҫ��ģ�ͣ����ڵȴ�/֪ͨ���ơ�������/������ģ������������һ�黺������Ϊ�ֿ⣬�����߿ɽ���Ʒ����ֿ⣬�����߿��ԴӲֿ���ȡ����Ʒ��
 * ������������ʱ�������߲������ѣ����������ѵ�ʱ�������߲�����������������ʱ�����߲������ѣ���������ʱ�����߲�������
 * �ŵ㣺���ͨ��ƽ�������ߺ������ߵĴ���������������崦�����ݵ��ٶȡ�
 * ������/������ģ�����մﵽ��Ŀ����ƽ�������ߺ������ߵĴ���������
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
				System.out.println("Set��ֵ�ǣ�" + value);
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
				System.out.println("Get��ֵ�ǣ�" + ValueObject.value);
				ValueObject.value = "";
				lock.notify();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}