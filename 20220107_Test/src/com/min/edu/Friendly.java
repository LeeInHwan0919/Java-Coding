package com.min.edu;

/**
 * 패키지명 추가 해주어야 해요
 */

public class Friendly {
	private boolean ischeck(int Num, int chkNum) {
		boolean isc = false;
		if (Num % chkNum == 0) {// 진약수구하기
			isc = true;
		} else {
			isc = false;
		}
		return isc;
	}

	private int YaksuSum(int Num) {
		int sum = 0; // 약수의 합 구하기
		for (int i = 1; i < Num; i++) {
			if (ischeck(Num, i)) {
				sum += i;
			}
		}
		return sum;
	}

	public void friendlyNum(int area) {
		for (int i = 0; i < area; i++) {
			int tmp = i; // 친화수 구하기
			int aSum = YaksuSum(tmp);
			int bSum = YaksuSum(aSum);
			if (tmp < aSum && tmp == bSum) {
				System.out.printf("%d와 %d는 친화수로 판단", tmp, aSum);
			}
		}
	}
}
