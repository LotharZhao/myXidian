/**
 * IO:BufferedReader,BufferedWriter
 */
package com.zhao.vii;

import java.io.*;

public class Demo5 {
	public static void main(String[] args) {
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			FileReader fr = new FileReader("E:\\ÎÄµµ\\myCode\\aa\\tt.txt");
			br = new BufferedReader(fr);
			bw = new BufferedWriter(
					new FileWriter("E:\\ÎÄµµ\\myCode\\aa\\dd.txt"));
			String s;
			while ((s = br.readLine()) != null) {
				System.out.println(s);
				bw.write(s+"\r\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
