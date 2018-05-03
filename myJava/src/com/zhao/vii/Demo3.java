/**
 * IO:拷贝图片
 */
package com.zhao.vii;

import java.io.*;

public class Demo3 {
	public static void main(String[] args) {
		// 把图片读入到内存-->写入到某个文件（用字节流）
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream("E:/图片/背景图片/1460600010161.jpg");
			fos = new FileOutputStream("E:\\文档\\myCode\\aa\\pp.jpg");

			byte[] buf = new byte[1024];
			int n = 0;
			while ((n = fis.read(buf)) != -1) {
				// 输出到指定文件
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
