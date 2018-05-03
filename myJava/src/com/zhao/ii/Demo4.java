/**
 * ถþฮฌสýื้
 */
package com.zhao.ii;

public class Demo4 {
	public static void main(String[] args) {
		int a[][] = new int[4][6];
		a[0][2] = 3;
		a[1][0] = 1;
		a[2][3] = 2;

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 6; j++)
				System.out.print(a[i][j] + " ");
			System.out.println();
		}
	}
}
