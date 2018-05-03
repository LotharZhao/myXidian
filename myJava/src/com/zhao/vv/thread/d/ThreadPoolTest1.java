package com.zhao.vv.thread.d;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池
 * 减少了创建和销毁线程的次数，每个工作线程都可以被重复利用，可执行多个任务
 * 可以根据系统的承受能力，调整线程池中工作线程的数据，防止因为消耗过多的内存导致服务器崩溃
 * 默认情况下，线程池中没有任何线程，而是等待有任务到来才创建线程去执行任务
 * @author zhaoliangtao
 *
 */
public class ThreadPoolTest1 {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		final List<Integer> l = new LinkedList<Integer>();
		/*
		 * ThreadPoolExecutor(int corePoolSize,/// 核心池的大小
                              int maximumPoolSize,/// 池中允许的最大线程数
                              long keepAliveTime,/// 当线程数大于corePoolSize时，终止前多余的空闲线程等待新任务的最长时间
                              TimeUnit unit,/// keepAliveTime的时间单位
                              BlockingQueue<Runnable> workQueue)/// 排队策略，存储还没来得及执行的任务
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
