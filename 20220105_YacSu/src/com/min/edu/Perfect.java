package com.min.edu;

public class Perfect {

	
	public void perfectNum(int area) {
		for (int i = 2; i <= area; i++) {
			if(i == yacsuSum(i)) {
				System.out.println(i+"는 완전수 입니다.");
			}
		}
	}
	
	// TODO 002.진약수의 합을 반환하는 메소드
	public int yacsuSum(int num) {
		int sum = 0;
		for (int i = 1; i < num; i++) {
			if (check(num, i)) {
				sum += i;// sum = sum + i;
			}
		}
		return sum;
	}

	// TODO 001.판단 메소드
	/**
	 * 판단 메소드
	 * 
	 * @param num    대상숫자
	 * @param chkNum 대상숫자의 진약수 확인 정수
	 * @return true이면 진약수
	 */
	public boolean check(int num, int chkNum) {
		boolean isc = false;
		if (num % chkNum == 0) {
			isc = true;
		} else {
			isc = false;
		}
		return isc;
	}

}
