package com.zhao.vv.collections.queue;

import java.util.PriorityQueue;

public class PriorityQueueTest {
	public static void main(String[] args) {
		PriorityQueue pq = new PriorityQueue();
		// �������������pq�м����ĸ�Ԫ��
//		pq.offer(6);
//		pq.offer(-3);
//		pq.offer(9);
//		pq.offer(0);

		pq.offer("saas");
		pq.offer("sadf");
		// ���pq���У������ǰ�Ԫ�صļ���˳�����У�
		// ���ǰ�Ԫ�صĴ�С˳�����У����[-3, 0, 9, 6]
		System.out.println(pq);
		// ���ʶ��е�һ��Ԫ�أ���ʵ���Ƕ�������С��Ԫ�أ�-3
		System.out.println(pq.poll());
	}
}