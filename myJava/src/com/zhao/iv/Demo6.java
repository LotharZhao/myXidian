/**
 * �������1
 */
package com.zhao.iv;

import java.awt.*;
import javax.swing.*;

public class Demo6 extends JFrame {

	JPanel jp1, jp2, jp3;
	JButton jb1, jb2;
	JLabel jlb1, jlb2;
	JTextField jtf;
	JPasswordField jpf;

	public static void main(String[] args) {
		Demo6 d6 = new Demo6();
	}

	public Demo6() {
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();

		jb1 = new JButton("��½");
		jb2 = new JButton("ע��");

		jlb1 = new JLabel("�û���");
		jlb2 = new JLabel("��    ��");

		jtf = new JTextField(10);
		jpf = new JPasswordField(10);

		this.setLayout(new GridLayout(3, 1));

		jp1.add(jlb1);
		jp1.add(jtf);
		jp2.add(jlb2);
		jp2.add(jpf);
		jp3.add(jb1);
		jp3.add(jb2);

		this.add(jp1);
		this.add(jp2);
		this.add(jp3);

		this.setTitle("��½����");
		this.setSize(300, 150);
		this.setLocation(200, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
