/**
 * ��������
 */
package com.zhao.viii.server;

import java.io.*;
import java.net.*;

public class MyServer1 {
	public static void main(String[] args) {
		MyServer1 ms = new MyServer1();
	}

	public MyServer1() {
		try {
			// ��9999�˿ڼ���
			ServerSocket ss = new ServerSocket(9999);
			System.out.println("����������9999�˿ڼ���...");

			// �ȴ�ĳ���ͻ�������
			Socket s = ss.accept();// �᷵��һ��socket����

			// Ҫ��ȡs���ݵ�����
			BufferedReader br = new BufferedReader(new InputStreamReader(
					s.getInputStream()));
			String info = br.readLine();
			System.out.println("�������յ���" + info);

			// ������
			PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
			pw.println("hello client");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
