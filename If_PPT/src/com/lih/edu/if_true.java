package com.lih.edu;

public class if_true {

	public static void main(String[] args) {
//		int a = 10, b = 20, c = 30;
//		int max;
//		if(a>b&&a>c)	{
//			max = a; // 위의 조건식이 true일때 실행
//		} else {  // 위의 조건식이 false일때 실행
//			if (b > c) {
//				max = b; // 위의 조건식 true일때 실행
//			} else {
//				max = c; // 위의 조건식 false일때 실행
//			}
//		}System.out.println("max ="+max);

//		int a = 2;
//		if (a == 3) {
//			for (int i = 0; i < 10; i++) {
//				System.out.print(i);
//			}
//		}else {
//			for (int i = 11; i < 20; i++) {
//				System.out.print(i+" ");
//			}
//		}

		int a = 2;
		while (true) {
			if (a == 3) {
				for (int i = 0; i < 10; i++) {
					System.out.print(i);
				}
				break;
			} else {
				for (int i = 11; i < 20; i++) {
					System.out.print(i + " ");
				}
			}
			break;

		}
	}
}
