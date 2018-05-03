/**
 * 拆分窗格
 */
package com.zhao.iv;

import javax.swing.*;

public class Demo9 extends JFrame {

	JSplitPane jsp;
	JList jl;
	JLabel jlb;

	public static void main(String[] args) {
		Demo9 d9 = new Demo9();
	}

	public Demo9() {
		String words[] = { "boy", "girl", "bird" };
		jl = new JList(words);

		jlb = new JLabel(new ImageIcon("images/iv_Demo9.jpg"));

		jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, jl, jlb);

		jsp.setOneTouchExpandable(true);

		this.add(jsp);

		this.setTitle("界面");
		this.setIconImage(new ImageIcon("images/qq.gif").getImage());
		this.setSize(300, 300);
		this.setLocation(200, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
