/**
 * �ͻ���
 */
package com.zhao.viii.client;

import java.io.*;
import java.net.*;

public class MyClient1 {
	public static void main(String[] args) {
		MyClient1 mc = new MyClient1();
	}

	public MyClient1() {
		try {
			// ����ĳ����������ip�Ͷ˿ں�
			Socket s = new Socket("127.0.0.1", 9999);
			// ͨ��pw��sд����,true��ʾ��ʱˢ��
			PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
			pw.println("hello server");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(
					s.getInputStream()));
			String info = br.readLine();
			System.out.println("�͑����յ���" + info);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
