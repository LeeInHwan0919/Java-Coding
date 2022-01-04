package com.min.edu;

public class RealStar {

	public void head(int n) {
		// for1
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < 2 * n - i + 1; j++) {
				System.out.print("☆");
			}
			for (int j2 = 0; j2 < i * 2 - 1; j2++) {
				System.out.print("★");
			}
			for (int j = 0; j < 2 * n - i + 1; j++) {
				System.out.print("☆");
			}
			System.out.println();
		}
	}// head

	public void middleTop(int n) {
		// for2
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print("☆");
			}
			for (int j = 0; j < n * 4 - i * 2 + 1; j++) {
				System.out.print("★");
			}
			for (int j = 0; j < i; j++) {
				System.out.print("☆");
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
			for (int j = 0; j < n - i - 2; j++) {
				System.out.print("☆");
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
			for (int j = 0; j < n + i + 1; j++) {
				System.out.print("☆");
			}
			System.out.println();
		}
	}
}// class
