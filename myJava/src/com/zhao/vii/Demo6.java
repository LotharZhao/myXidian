/**
 * 记事本
 */
package com.zhao.vii;

import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class Demo6 extends JFrame implements Action {

	JTextArea jta = null;
	JMenuBar jmb = null;
	JMenu jm1 = null;
	JMenuItem jmi1, jmi2;

	public static void main(String[] args) {
		Demo6 d = new Demo6();
	}

	public Demo6() {
		jta = new JTextArea();
		jmb = new JMenuBar();
		jm1 = new JMenu("文件");
		jm1.setMnemonic('F');// 设置助记符
		jmi1 = new JMenuItem("打开", new ImageIcon("images/qq.gif"));
		jmi2 = new JMenuItem("保存");

		jmi1.addActionListener(this);// 设置监听
		jmi1.setActionCommand("open");
		jmi2.addActionListener(this);
		jmi2.setActionCommand("save");

		this.setJMenuBar(jmb);
		jmb.add(jm1);
		jm1.add(jmi1);
		jm1.add(jmi2);

		this.add(jta);
		this.setTitle("记事本");
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("open")) {
			System.out.println("open");

			JFileChooser jfc = new JFileChooser();// 文件选择组件
			jfc.setDialogTitle("请选择文件...");
			jfc.showOpenDialog(null);// 默认方式
			jfc.setVisible(true);

			// 得到用户选择的文件路径
			String filename = jfc.getSelectedFile().getAbsolutePath();
			System.out.println(filename);

			FileReader fr = null;
			BufferedReader br = null;
			try {
				fr = new FileReader(filename);
				br = new BufferedReader(fr);

				// 从文件中读取信息并显示到jta
				String s = "";
				String allCon = "";
				while ((s = br.readLine()) != null) {
					allCon += s + "\r\n";
				}
				jta.setText(allCon);
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			} finally {
				try {
					br.close();
					fr.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
		if (e.getActionCommand().equals("save")) {
			JFileChooser jfc = new JFileChooser();
			jfc.setDialogTitle("另存为..");
			jfc.showSaveDialog(null);
			jfc.setVisible(true);

			String filename = jfc.getSelectedFile().getAbsolutePath();

			FileWriter fw = null;
			BufferedWriter bw = null;
			try {
				fw = new FileWriter(filename);
				bw = new BufferedWriter(fw);

				bw.write(this.jta.getText());
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			} finally {
				try {
					bw.close();
					fw.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	@Override
	public Object getValue(String key) {
		return null;
	}

	@Override
	public void putValue(String key, Object value) {
	}
}
