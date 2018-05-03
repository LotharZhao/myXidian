/**
 * ������
 * ȫ˫��
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

	PrintWriter pw = null;// ����Ϣ�����ͻ��˵Ķ���

	public static void main(String[] args) {
		MyServer3 ms = new MyServer3();
	}

	public MyServer3() {
		jta = new JTextArea();
		jsp = new JScrollPane(jta);
		jtf = new JTextField(20);
		jb = new JButton("����");
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
			// ����������
			ServerSocket ss = new ServerSocket(9988);
			// �ȴ��ͻ�������
			Socket s = ss.accept();

			InputStreamReader isr = new InputStreamReader(s.getInputStream());
			BufferedReader br = new BufferedReader(isr);
			pw = new PrintWriter(s.getOutputStream(), true);

			// ��ȡ�ͻ��˷�������Ϣ
			while (true) {
				String info = br.readLine();
				jta.append("�ͻ��� �� ������ ˵:" + info + "\r\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// ����û����·�����Ϣ��ť
		if (e.getSource() == jb) {
			// �ѷ�������jtfд�����ݷ����ͻ���
			String info = jtf.getText();
			jta.append("������ �� �ͻ��� ˵:" + info + "\r\n");
			pw.println(info);
			// ���jtf����
			jtf.setText("");
		}
	}
}
