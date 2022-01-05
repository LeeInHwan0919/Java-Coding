package com.min.edu;

public class Friendly {

	public void friendlyNum(int area) {

		for (int i = 0; i < area; i++) {
			int tmp = i;
			int aSum = yacsuSum(tmp);// 284
			int bSum = yacsuSum(aSum);// 220
			if (tmp < aSum && tmp == bSum) {
				System.out.printf("%d와 %d는 친화수로 판단됨%n", tmp, aSum);
			}
		}

//		for (int i = 2; i <= area; i++) {// 확인하기 위한것이고 1은 완전수이자 친화수 이므로 제외 2부터시작해도됨
//			for (int j = 2; j <= area; j++) {// 확인하기 위한것이고 1은 완전수이자 친화수 이므로 제외 2부터시작해도됨
//				if (i != j && i == yacsuSum(j) && yacsuSum(i) == j) {
//					System.out.printf("%d와 %d는 친화수 입니다.%n", i, j);
//				}
//			}
//		}
	}

	private int yacsuSum(int num) {
		int result = 0;
		for (int i = 1; i < num; i++) {
			if (check(num, i)) {
				result += i;
			}
		}
		return result;
	}

	private boolean check(int num, int chkNum) {
		return (num % chkNum == 0) ? true : false;// 삼항연산자
	}

}
