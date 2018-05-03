/**
 * IO:FileInputStream,FileOutputStream
 */
package com.zhao.vii;

import java.io.*;

public class Demo2 {
	public static void main(String[] args) {
		File f = new File(
				"E:\\�ĵ�\\myCode\\myJava\\src\\com\\zhao\\vii\\Demo2.java");

		FileInputStream fis = null;
		try {
			fis = new FileInputStream(f);

			byte[] bytes = new byte[1024];
			int n = 0;// �õ�ʵ�ʶ�ȡ�����ֽ���
			while ((n = fis.read(bytes)) != -1) {
				// ���ֽ�ת��String
				String s = new String(bytes, 0, n);
				System.out.println(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// �ر��ļ��������������
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		File f2 = new File("E:\\�ĵ�\\myCode\\aa\\tt.txt");

		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(f2);

			String s = "��Һã�����aaa\r\n";
			String s2 = "�й���������";
			fos.write(s.getBytes());
			fos.write(s2.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
