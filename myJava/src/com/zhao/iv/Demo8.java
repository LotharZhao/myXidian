/**
 * �������3
 */
package com.zhao.iv;

import java.awt.*;
import javax.swing.*;

public class Demo8 extends JFrame {

	JPanel jp1, jp2;
	JLabel jlb1, jlb2;
	JComboBox jcb;
	JList jl;
	JScrollPane jsp;

	public static void main(String[] args) {
		Demo8 d8 = new Demo8();
	}

	public Demo8() {
		jp1 = new JPanel();
		jp2 = new JPanel();

		jlb1 = new JLabel("����");
		jlb2 = new JLabel("����2");

		String jg[] = { "����", "�Ϻ�", "���", "����" };
		jcb = new JComboBox(jg);

		String dd[] = { "����", "�Ϻ�", "���", "����" };
		jl = new JList(dd);
		jl.setVisibleRowCount(3);
		jsp = new JScrollPane(jl);

		this.setLayout(new GridLayout(3, 1));

		jp1.add(jlb1);
		jp1.add(jcb);
		jp2.add(jlb2);
		jp2.add(jsp);

		this.add(jp1);
		this.add(jp2);

		this.setTitle("ע�����2");
		this.setSize(300, 300);
		this.setLocation(200, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
