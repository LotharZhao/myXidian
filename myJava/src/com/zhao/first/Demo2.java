package com.zhao.first;

public class Demo2 
{
	public static void main(String[] args) 
	{
		/*
		int a = 12;

		if (a>=18){
			System.out.println("成年");
		}else if(a>10&&a<18){
			System.out.println("青年");
		}else{
			System.out.println("少年");
		}
		*/
		//根据用户输入，判断是星期几
		char c = 'b';
		switch(c){
			case 'a':
				System.out.println("aa");
				break;
			case 'b':
				System.out.println("bb");
			default:
				System.out.println("...");
		}
	}
}
