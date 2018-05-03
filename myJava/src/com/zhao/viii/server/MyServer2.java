/**
 * 服务器端
 * 半双工
 */
package com.zhao.viii.server;

import java.io.*;
import java.net.*;

public class MyServer2 {
	public static void main(String[] args) {
		MyServer2 ms = new MyServer2();
	}

	public MyServer2() {
		try {
			ServerSocket ss = new ServerSocket(9999);
			System.out.println("服务器正在9999端口监听...");
			Socket s = ss.accept();

			BufferedReader br1 = new BufferedReader(new InputStreamReader(
					s.getInputStream()));
			PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
			BufferedReader br2 = new BufferedReader(new InputStreamReader(
					System.in));

			while (true) {
				String info = br1.readLine();
				System.out.println("收到：" + info);
				if (info.equals("over")) {
					s.close();
					break;
				}

				System.out.print("输入：");
				String res = br2.readLine();
				pw.println(res);
				if (res.equals("over")) {
					s.close();
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
