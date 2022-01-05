package com.min.edu;

public class Diamond_Seperate {

	static int n = 4;
	
	// 층수만 입력 해주는 메소드
	public static void solomon() {
		for (int i = 1; i < n; i++) {
			shape(i);
		}
		for (int i = n; i > 0; i--) {
			shape(i);
		}
	}
	// 입력받은 층수에 해당하는 ROW를 그려주는 메소드
	public static void shape(int i) {
		for (int j = 0; j < n-i; j++) {
			System.out.print("○");
		}
		for (int j = 0; j < (2*i)-1; j++) {
			System.out.print("●");
		}
		System.out.println();
	}
	
}
