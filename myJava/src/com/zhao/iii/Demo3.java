/**
 * LinkList
 * Vector,Stackջ
 * HashMap
 */
package com.zhao.iii;

import java.util.*;

public class Demo3 {
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		Emp emp1 = new Emp("001", "aa", 1000f);
		Emp emp2 = new Emp("002", "bb", 1500f);
		ll.addFirst(emp1);
		ll.addFirst(emp2);
		for (int i = 0; i < ll.size(); i++) {
			Emp emp = (Emp) ll.get(i);
			System.out.println(emp.getName());
		}

		Vector v = new Vector();// Stack��ͬ
		v.add(emp1);
		v.add(emp2);
		for (int i = 0; i < ll.size(); i++) {
			Emp emp = (Emp) v.get(i);
			System.out.println(emp.getName());
		}

		HashMap hm = new HashMap();// ��Hashtable����һ��
		hm.put("001", emp1);// ��<-->ֵ
		hm.put("002", emp2);
		hm.put("003", emp2);
		hm.put("003", emp1);// key��Ψһ��
		if (hm.containsKey("003")) {
			System.out.println("�и�Ա��");
			Emp emp = (Emp) hm.get("003");
			System.out.println(emp.getName());
		} else
			System.out.println("û�и�Ա��");
		Iterator it = hm.keySet().iterator();// ������������HashMap
		while (it.hasNext()) {
			String key = it.next().toString();// ȡ��key
			Emp emp = (Emp) hm.get(key);// ͨ��keyȡ��value
			System.out.println(emp.getName());
		}

		Hashtable ht = new Hashtable();
//		ht.put(null, null);// ������null
//		System.out.println(ht.get(null));
		hm.put(null, null);
		System.out.println(hm.get(null));
	}
}