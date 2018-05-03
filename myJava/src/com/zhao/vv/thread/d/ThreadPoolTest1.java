package com.zhao.vv.thread.d;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * �̳߳�
 * �����˴����������̵߳Ĵ�����ÿ�������̶߳����Ա��ظ����ã���ִ�ж������
 * ���Ը���ϵͳ�ĳ��������������̳߳��й����̵߳����ݣ���ֹ��Ϊ���Ĺ�����ڴ浼�·���������
 * Ĭ������£��̳߳���û���κ��̣߳����ǵȴ����������Ŵ����߳�ȥִ������
 * @author zhaoliangtao
 *
 */
public class ThreadPoolTest1 {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		final List<Integer> l = new LinkedList<Integer>();
		/*
		 * ThreadPoolExecutor(int corePoolSize,/// ���ĳصĴ�С
                              int maximumPoolSize,/// �������������߳���
                              long keepAliveTime,/// ���߳�������corePoolSizeʱ����ֹǰ����Ŀ����̵߳ȴ���������ʱ��
                              TimeUnit unit,/// keepAliveTime��ʱ�䵥λ
                              BlockingQueue<Runnable> workQueue)/// �ŶӲ��ԣ��洢��û���ü�ִ�е�����
		 * 
		 */
		ThreadPoolExecutor tp = new ThreadPoolExecutor(100, 100, 60, TimeUnit.SECONDS,
				new LinkedBlockingQueue<Runnable>());
		final Random random = new Random();
		for (int i = 0; i < 20000; i++) {
			tp.execute(new Runnable() {
				public void run() {
					l.add(random.nextInt());
				}
			});
		}
		tp.shutdown();
		try {
			tp.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(System.currentTimeMillis() - startTime);
		System.out.println(l.size());
	}
}
