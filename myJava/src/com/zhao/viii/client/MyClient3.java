package com.zhao.viii.client;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;

public class MyClient3 extends JFrame implements ActionListener {

	JTextArea jta = null;
	JTextField jtf = null;
	JButton jb = null;
	JScrollPane jsp = null;
	JPanel jp = null;

	PrintWriter pw = null;

	public static void main(String[] args) {
		MyClient3 mc = new MyClient3();
	}

	public MyClient3() {
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

		this.setTitle("MyClient3");
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

		try {
			Socket s = new Socket("127.0.0.1", 9988);

			InputStreamReader isr = new InputStreamReader(s.getInputStream());
			BufferedReader br = new BufferedReader(isr);
			pw = new PrintWriter(s.getOutputStream(), true);

			// 读取服务器发来的信息
			while (true) {
				String info = br.readLine();
				jta.append("服务器 对 客户端 说:" + info + "\r\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jb) {
			String info = jtf.getText();
			jta.append("客户端 对 服务器 说:" + info + "\r\n");
			pw.println(info);
			jtf.setText("");
		}
	}
}
