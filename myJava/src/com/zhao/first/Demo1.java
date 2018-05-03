/*
	作者：
	功能：判断两个书是否能整除
	日期：
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
			System.out.println("可以整除!");
		}else {
			System.out.println("不可以整除!");
		}
		
		int c = 3;
		int d = (++c)--;//意外的类型
		System.out.println(d);
		*/
		try{
			//输入流，从键盘接收数
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			
			//提示
			System.out.print("请输入第一个数:  ");
			//从控制台读取一行数据
			String a1 = br.readLine();

			System.out.print("请输入第二个数:  ");
			String a2 = br.readLine();
			
			//String-->float
			float num1 = Float.parseFloat(a1);
			float num2 = Float.parseFloat(a2);

			if(num1>num2){
				System.out.println("第一个大！");
			}else if(num1<num2){
				System.out.println("第二个大！");
			}else{
				System.out.println("相等!");
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
