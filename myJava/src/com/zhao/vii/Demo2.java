/**
 * IO:FileInputStream,FileOutputStream
 */
package com.zhao.vii;

import java.io.*;

public class Demo2 {
	public static void main(String[] args) {
		File f = new File(
				"E:\\文档\\myCode\\myJava\\src\\com\\zhao\\vii\\Demo2.java");

		FileInputStream fis = null;
		try {
			fis = new FileInputStream(f);

			byte[] bytes = new byte[1024];
			int n = 0;// 得到实际读取到的字节数
			while ((n = fis.read(bytes)) != -1) {
				// 把字节转成String
				String s = new String(bytes, 0, n);
				System.out.println(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭文件流，必须放这里
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		File f2 = new File("E:\\文档\\myCode\\aa\\tt.txt");

		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(f2);

			String s = "大家好！！！aaa\r\n";
			String s2 = "中国共产党！";
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
