/**
 * IO:file��
 */
package com.zhao.vii;

import java.io.*;

public class Demo1 {
	public static void main(String[] args) {
		// �����ļ��ʹ����ļ���
		File f2 = new File("E:/�ĵ�/myCode/aa");
		if (f2.isDirectory())
			System.out.println("���ļ����Ѵ���");
		else
			f2.mkdir();

		File f = new File("E:\\�ĵ�\\myCode\\aa\\bb.txt");
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else
			System.out.println("���ļ��Ѵ��ڣ����ܴ���");

		System.out.println(f.getAbsolutePath());// �ļ���·��
		System.out.println(f.length());// �ļ���С

		// �г��ļ����µ������ļ�
		File f3 = new File("E:\\�ĵ�\\myCode");
		if (f3.isDirectory()) {
			File lists[] = f3.listFiles();
			for (int i = 0; i < lists.length; i++) {
				System.out.println(lists[i].getName());
			}
		}
	}
}
