/**
 * IO:拷贝文本文件
 */
package com.zhao.vii;

import java.io.*;

public class Demo4 {
	public static void main(String[] args) {
		FileReader fr = null;
		FileWriter fw = null;
		try {
			fr = new FileReader("E:\\文档\\myCode\\aa\\tt.txt");
			fw = new FileWriter("E:\\文档\\myCode\\aa\\cc.txt");

			char[] c = new char[1024];
			int n = 0;
			while ((n = fr.read(c)) != -1) {
				System.out.println(c);

				fw.write(c,0,n);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
