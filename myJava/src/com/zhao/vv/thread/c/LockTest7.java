package com.zhao.vv.thread.c;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ��д��ReentrantReadWriteLock
 * ��д����ʾ��������һ���Ƕ�������ص�������Ϊ����������һ����д������ص�������Ϊ������
 * ���Thread����ͬʱ���ж�ȡ����������ͬһʱ��ֻ����һ��Thread����д�����
 * ���Ͷ�֮�䲻���⣬��Ϊ�������������̰߳�ȫ����
 * д��д֮�以�⣬����һ��д����Ӱ������һ��д�����������̰߳�ȫ����
 * ����д֮�以�⣬�����������ʱ��д�����޸������ݣ������̰߳�ȫ����
 * @author zhaoliangtao
 *
 */
class Domain7 extends ReentrantReadWriteLock {
	public void read() {
		try {
			readLock().lock();
			System.out.println(Thread.currentThread().getName() + "����˶���, ʱ��Ϊ" + System.currentTimeMillis());
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			readLock().unlock();
		}
	}

	public void write() {
		try {
			writeLock().lock();
			System.out.println(Thread.currentThread().getName() + "�����д��, ʱ��Ϊ" + System.currentTimeMillis());
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			writeLock().unlock();
		}
	}
}

public class LockTest7 {
	public static void main(String[] args) throws InterruptedException {
		final Domain7 td = new Domain7();
		Runnable readRunnable = new Runnable() {
			public void run() {
				td.read();
			}
		};
		Runnable writeRunnable = new Runnable() {
			public void run() {
				td.write();
			}
		};

		Thread t0 = new Thread(readRunnable);
		Thread t1 = new Thread(readRunnable);
		t0.start();
		t1.start();

		Thread t2 = new Thread(writeRunnable);
		Thread t3 = new Thread(writeRunnable);
		t2.start();
		t3.start();
	}
	/**
1��synchronized�ǹؼ��֣��ͺ�if...else...һ�������﷨�����ʵ�֣����synchronized��ȡ���Լ��ͷ�������Java����������û���ɵģ�ReentrantLock��������ʵ�֣�������Ļ�ȡ�Լ������ͷŶ���Ҫ�û��Լ�ȥ�������ر��ٴ����ѣ�ReentrantLock��lock()���ˣ�һ��Ҫ�ֶ�unlock()

2��synchronized�򵥣�����ζ�Ų�����ReentrantLock�������Ƹ��û���ʹ���ṩ�˼��������ԡ������Hashtable��ConcurrentHashMap�����ֵ����쾡�¡�synchronizedһ����������Hash����ConcurrentHashMap������ReentrantLockʵ���������룬����ֻ��segment����������Hash��

3��synchronized�ǲ���ƽ������ReentrantLock����ָ�����ǹ�ƽ�Ļ��Ƿǹ�ƽ��

4��synchronizedʵ�ֵȴ�/֪ͨ����֪ͨ���߳�������ģ�ReentrantLockʵ�ֵȴ�/֪ͨ���ƿ�����ѡ���Ե�֪ͨ

5����synchronized��ȣ�ReentrantLock�ṩ���û����ַ�����������Ϣ�Ļ�ȡ���������֪��lock�Ƿ񱻵�ǰ�̻߳�ȡ��lock��ͬһ���̵߳����˼��Ρ�lock�Ƿ������̻߳�ȡ�ȵ�

�ܽ�����������Ϊ���ֻ��Ҫ�����򵥵ķ������򵥵Ĵ���飬��ô����ʹ��synchronized�����ӵĶ��̴߳������¿��Կ���ʹ��ReentrantLock
	 */
}
