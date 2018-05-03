package com.zhao.viii.client;

import java.io.*;
import java.net.*;

public class MyClient2 {
	public static void main(String[] args) {
		MyClient2 mc = new MyClient2();
	}

	public MyClient2() {
		try {
			Socket s = new Socket("127.0.0.1", 9999);
			PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
			BufferedReader br1 = new BufferedReader(new InputStreamReader(
					System.in));
			BufferedReader br2 = new BufferedReader(new InputStreamReader(
					s.getInputStream()));
			while (true) {
				System.out.print(" ‰»Î£∫");
				String info = br1.readLine();
				pw.println(info);
				if (info.equals("over")) {
					s.close();
					break;
				}

				String res = br2.readLine();
				System.out.println(" ’µΩ£∫" + res);
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
