package com.zhao.first;

public class Demo3 
{
	public static void main(String[] args) 
	{
		/*
		for(int i=1;i<=10;i++){
			int index = 0;
			index = i;
			for(int j=1;j<i;j++){
				index*=i;
			}
			System.out.println("Hello "+index+" World!");
		}
		
		int i = 0;
		while(i<10){
			System.out.println("Hello + "+i);
			i++;
		}

		int j = 10;
		do{
			System.out.println("World + "+j);
			j++;
		}while(j<10);
		*/
		int lay = 10;
		for(int i=0;i<lay;i++){
			for(int k=0;k<lay-i;k++){
				System.out.print(" ");
			}
			if(i==lay-1){
				for(int j=0;j<i;j++)
					System.out.print("*"+" ");
				break;
			}else{
				for(int j=0;j<i;j++){
					if(j==0||j==i-1)
						System.out.print("*"+" ");
					else System.out.print("  ");
				}
				System.out.println();
			}
		}
	}
}
