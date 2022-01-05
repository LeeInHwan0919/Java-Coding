package com.min.edu;

public class Diamond_Div {

	public void printAll(int n) {
		 printIncrease(n);
		 printDecrease(n);

		
	}

	private void printIncrease(int n) {// 다이아 top

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < 2 * i + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private void printDecrease(int n) {// 다이아 bottom

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) { // 1 2 3 4
				System.out.print(" ");
			}
			for (int j = 0; j < 2 * (n - i) - 1; j++) {// 7 5 3 1
				System.out.print("*");
			}
			System.out.println();
		}
	}



}
