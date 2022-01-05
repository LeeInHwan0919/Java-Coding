package com.min.edu;

public class Triangle {
	// 29page 그림/설명
	public void one(int n) {// n의 테스트 값은 5
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < (i + 1); j++) {
				System.out.print("●");
			}

			System.out.println("");
		}
	}
}
