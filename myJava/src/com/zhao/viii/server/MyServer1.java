/**
 * 服务器端
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
			// 在9999端口监听
			ServerSocket ss = new ServerSocket(9999);
			System.out.println("服务器正在9999端口监听...");

			// 等待某个客户端连接
			Socket s = ss.accept();// 会返回一个socket连接

			// 要读取s传递的数据
			BufferedReader br = new BufferedReader(new InputStreamReader(
					s.getInputStream()));
			String info = br.readLine();
			System.out.println("服务器收到：" + info);

			// 回数据
			PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
			pw.println("hello client");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
