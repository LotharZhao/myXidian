/**
 * IO:file类
 */
package com.zhao.vii;

import java.io.*;

public class Demo1 {
	public static void main(String[] args) {
		// 创建文件和创建文件夹
		File f2 = new File("E:/文档/myCode/aa");
		if (f2.isDirectory())
			System.out.println("该文件夹已存在");
		else
			f2.mkdir();

		File f = new File("E:\\文档\\myCode\\aa\\bb.txt");
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else
			System.out.println("该文件已存在，不能创建");

		System.out.println(f.getAbsolutePath());// 文件的路径
		System.out.println(f.length());// 文件大小

		// 列出文件夹下的所有文件
		File f3 = new File("E:\\文档\\myCode");
		if (f3.isDirectory()) {
			File lists[] = f3.listFiles();
			for (int i = 0; i < lists.length; i++) {
				System.out.println(lists[i].getName());
			}
		}
	}
}
