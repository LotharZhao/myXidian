/*
	���ߣ�
	���ܣ��ж��������Ƿ�������
	���ڣ�
*/
package com.zhao.first;

import java.io.*;

public class Demo1
{
	public static void main(String[] args) 
	{
		/*
		int a = 2;
		int b = 4;
		if(b%a==0) {
			System.out.println("��������!");
		}else {
			System.out.println("����������!");
		}
		
		int c = 3;
		int d = (++c)--;//���������
		System.out.println(d);
		*/
		try{
			//���������Ӽ��̽�����
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			
			//��ʾ
			System.out.print("�������һ����:  ");
			//�ӿ���̨��ȡһ������
			String a1 = br.readLine();

			System.out.print("������ڶ�����:  ");
			String a2 = br.readLine();
			
			//String-->float
			float num1 = Float.parseFloat(a1);
			float num2 = Float.parseFloat(a2);

			if(num1>num2){
				System.out.println("��һ����");
			}else if(num1<num2){
				System.out.println("�ڶ�����");
			}else{
				System.out.println("���!");
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
