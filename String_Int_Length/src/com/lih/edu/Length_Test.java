package com.lih.edu;

public class Length_Test {

	public static void mathCasting() {
		int num = -10;
		int length = (int) (Math.log10(num) + 1); // 로직설명
		System.out.println("수학적 함수를 사용하여 정수의 길이 계산 : " + length);
	}

	public static int count_digit(int x) {
		int count = 0;
		while (x != 0) {
			x = x / 10;
			++count;
		}
		return count;
	}

	public static void count_digits(int x) {
		String dig = Integer.toString(x);
		System.out.println("toSting()함수를 사용하여 정수의 길이 계산 : "+dig.length());
	}
}
