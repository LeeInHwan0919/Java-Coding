package com.min.edu;

public class Break {
	public static void main(String[] args) {
		// 10 이상이라면 종료

//		int n = 0;
//		while (true) {
//			System.out.println(n++);
//			if (n >= 10) {
//				System.out.println(n + " 종료");
//				break;
//			}
//		}

//		int m = 0;
//		for (; m < 20; m++) {
//			System.out.println(m++);
//			if (m >= 0) {
//				System.out.println("종료");
//			}
//		}

		int k = 0;
		while (true) {
			for (; k < 20; k++) {
				if (k >= 10) {
					System.out.println("for 종료");
					break;
					}
				}//for
				System.out.println("while :" + k);
				if(k >40) {
					System.out.println("while 종료");
					System.out.println(k); 
				}
			}
		}
	}

