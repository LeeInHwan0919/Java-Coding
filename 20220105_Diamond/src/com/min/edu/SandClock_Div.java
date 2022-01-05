package com.min.edu;

public class SandClock_Div {
	
	public void printAll(int n) {
		printTopSand(n);
		printBottomSand(n);
	}

	private void printTopSand(int n) { // 모래 top

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) { // 1 2 3 4
				System.out.print(" ");
			}
			for (int j = 0; j < 2 * (n - i) - 1; j++) {// 7 5 3 1
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private void printBottomSand(int n) { // 모래 bottom

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < n - i - 1; j++) {// 3 2 1 0
				System.out.print(" ");
			}
			for (int j = 0; j < 2 * i + 1; j++) {// 3 5 7 9
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
