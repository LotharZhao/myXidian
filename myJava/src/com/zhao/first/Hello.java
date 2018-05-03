//作者
//功能：控制台显示“Hello”
//日期：

//public：表示这个类是公共的，一个java文件只能有一个pubic类
//class：表示一个类
//Hello：类名（公共类的类名必须跟文件名一致）
package com.zhao.first;

public class Hello
{
	//一个主函数，相当于程序入口
	public static void main(String[] args) 
	{
		//执行语句
		//System.out.println("Hello");

		/*
		int a = 10;
		int b = 20;
		int result = a+b;
		System.out.println("结果是:"+result);

		byte byte1 = -128;

		char test1 = '中';
		int test2 = 'a'+'b';
		char test3 = 'a'+12;
		System.out.println(test1+"+"+test2+"+"+test3);
		*/
		int a = 23;
		a = (int)2.3;
		double b = 1;
		float c = 2.3f;
		System.out.println(a+"+"+b+"+"+c);
	}
}
