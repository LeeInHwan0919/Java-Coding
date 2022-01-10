package com.min.edu;

public class Continue {
	public static void main(String[] args) {
		int odd = 0;
		int even = 0;
		for (int i = 0; i < 20; i++) {
			if (i % 2 == 0) {
				even += i;
				continue;
			}
			odd += i;

			if (i >= 16) { // 종료가 19일때
				System.out.println(i);
				break;
			}
		}
		System.out.println("홀수합 " + odd);
		System.out.println("짝수합 " + even);
	}
}
