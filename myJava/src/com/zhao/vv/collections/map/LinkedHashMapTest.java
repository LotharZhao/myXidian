package com.zhao.vv.collections.map;

import java.util.LinkedHashMap;

public class LinkedHashMapTest {
	public static void main(String[] args) {
		LinkedHashMap scores = new LinkedHashMap();
		scores.put("����", 80);
		scores.put("��ѧ", 76);
		scores.put("Ӣ��", 82);
		// ����scores������е�key-value��
		for (Object key : scores.keySet()) {
			System.out.println(key + "------>" + scores.get(key));
		}
	}
}