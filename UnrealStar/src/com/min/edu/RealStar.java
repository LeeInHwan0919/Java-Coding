package com.min.edu;

public class RealStar {

	public void leftdown(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("=============================");

	}

	public void leftup(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < n - i + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("=============================");

	}

	public void rightdown(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 4-i; j++) {
				System.out.print(" ");
			} 
			
			for (int j = 0; j < i+1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("=============================");

	}

	public void rightup(int n) {

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}

			for (int j = 0; j < n - i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		System.out.println("=============================");

	}

}
