/**
 * 客户端
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
			// 连接某个服务器，ip和端口号
			Socket s = new Socket("127.0.0.1", 9999);
			// 通过pw向s写数据,true表示及时刷新
			PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
			pw.println("hello server");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(
					s.getInputStream()));
			String info = br.readLine();
			System.out.println("客戶端收到：" + info);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
