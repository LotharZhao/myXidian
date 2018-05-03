/**
 * 服务器
 * 全双工
 */
package com.zhao.viii.server;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;

public class MyServer3 extends JFrame implements ActionListener {

	JTextArea jta = null;
	JTextField jtf = null;
	JButton jb = null;
	JScrollPane jsp = null;
	JPanel jp = null;

	PrintWriter pw = null;// 把信息发给客户端的对象

	public static void main(String[] args) {
		MyServer3 ms = new MyServer3();
	}

	public MyServer3() {
		jta = new JTextArea();
		jsp = new JScrollPane(jta);
		jtf = new JTextField(20);
		jb = new JButton("发送");
		jb.addActionListener(this);
		jp = new JPanel();

		jp.add(jtf);
		jp.add(jb);
		this.add(jsp, "Center");
		this.add(jp, "South");

		this.setTitle("MyServer3");
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

		try {
			// 服务器监听
			ServerSocket ss = new ServerSocket(9988);
			// 等待客户端连接
			Socket s = ss.accept();

			InputStreamReader isr = new InputStreamReader(s.getInputStream());
			BufferedReader br = new BufferedReader(isr);
			pw = new PrintWriter(s.getOutputStream(), true);

			// 读取客户端发来的信息
			while (true) {
				String info = br.readLine();
				jta.append("客户端 对 服务器 说:" + info + "\r\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 如果用户按下发送信息按钮
		if (e.getSource() == jb) {
			// 把服务器在jtf写的内容发给客户端
			String info = jtf.getText();
			jta.append("服务器 对 客户端 说:" + info + "\r\n");
			pw.println(info);
			// 清空jtf内容
			jtf.setText("");
		}
	}
}
