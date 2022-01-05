package com.min.edu;

public class Diamond_MathAPI {

	public void dia_math_api(int n) {
		for (int i = 0; i < n; i++) {
			System.out.print(Math.abs(i-n/2));
			for (int j = 0; j < Math.abs(i-n/2); j++) {
				System.out.print("◇");
			}
			for (int j = 0; j < n-2*(Math.abs(i-n/2)); j++) {
				System.out.print("◆");
			}
			for (int j = 0; j < Math.abs(i-n/2); j++) {
				System.out.print("◇");
			}
			System.out.println();
		}
	}
	
	
	
}
