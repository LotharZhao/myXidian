/**
 * IO:����ͼƬ
 */
package com.zhao.vii;

import java.io.*;

public class Demo3 {
	public static void main(String[] args) {
		// ��ͼƬ���뵽�ڴ�-->д�뵽ĳ���ļ������ֽ�����
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream("E:/ͼƬ/����ͼƬ/1460600010161.jpg");
			fos = new FileOutputStream("E:\\�ĵ�\\myCode\\aa\\pp.jpg");

			byte[] buf = new byte[1024];
			int n = 0;
			while ((n = fis.read(buf)) != -1) {
				// �����ָ���ļ�
				fos.write(buf);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
