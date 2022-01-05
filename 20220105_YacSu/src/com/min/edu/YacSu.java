package com.min.edu;

/**
 * 입력받은 수의 진약수를 판단하여, 갯수, 합을 출력하는 클래스
 * 
 * @author Lee In Hwan
 *
 */
public class YacSu {

	// 약수의 합과, 갯수를 출력하는 메소드
	public void yacsu_print(int num) {
		int cnt = 0;
		int sum = 0;
		for (int i = 1; i < num; i++) {
			if (isCheck(num, i)) {// true라면 약수
				cnt++;
				sum += i; // sum = sum + i
			}

		}
		System.out.printf("%d의 진약수의 갯수는 %d / 합은 %d", num, cnt, sum);
	}

	// 특정한 숫자 chkNum이 num의 진약수 인지 판단하는 메소드
	public boolean isCheck(int num, int chkNum) {
		boolean isc = false;
		if (num % chkNum == 0) {
			isc = true;
		} else {
			isc = false;
		}

		return isc;
	}

}
