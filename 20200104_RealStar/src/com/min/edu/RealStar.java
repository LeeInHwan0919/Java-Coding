package com.min.edu;

public class RealStar {

	public void head(int n) {
		// for1
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 3 * n - 2-i; j++) {// 13	12	11	10	9
				System.out.print("☆");
			}
			for (int j2 = 0; j2 < 2 * i + 1; j2++) {//1	 3	 5	 7    9	
				System.out.print("★");
			}

			System.out.println();
		}
	}// head

	public void middleTop(int n) {
		// for2
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {// 0	1	2	3	4 ...
				System.out.print("☆");
			}
			for (int j = 0; j < 5 * n + 2 - 2 * i; j++) {// 27	25	23	21	19 ...
				System.out.print("★");
			}

			System.out.println();
		}
	}

	public void middleBottom(int n) {
		// for3
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 2; j++) {
				System.out.print("☆");
			}
			for (int j = 0; j < n * 2 + i * 2 + 5; j++) {
				System.out.print("★");
			}

			System.out.println();
		}
	}

	public void foot(int n) {
		// for4
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n + i + 1; j++) {
				System.out.print("☆");
			}
			for (int j = 0; j < n * 2 - i * 2 - 1; j++) {
				System.out.print("★");
			}

			System.out.println();
		}
	}
}// class
