/**
 * �쳣
 */
package com.zhao.iii;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.Socket;

public class Demo6 {
	public static void main(String[] args) {
		// ������쳣
		try {
			Socket s = new Socket("192.1688.1.23", 780);// �����ڵĶ˿�
			System.out.println("ok1");
			FileReader fr = new FileReader("d:\\a.text");// �򿪲����ڵ��ļ�
		} catch (FileNotFoundException e) {
			// ���쳣����Ϣ����������ų�bug
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("ok2");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("ok3");
		} finally {
			System.out.println("finally");
		}
		System.out.println("ok4");

		// �������쳣
		// int a = 4 / 0;// 0����
		// int arr[] = { 1, 2, 3 };
		// System.out.println(arr[3]);// ����Խ��

		Father f = new Father();
		f.test1();
	}
}

// throws
class Father {
	private Son son = null;

	public Father() {
		son = new Son();
	}

	public void test1() {
		try {
			son.test2();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("father");
		}
	}
}

class Son {
	public void test2() throws Exception {
		FileReader fr = null;
		fr = new FileReader("d:\\dd.text");
	}
}
