package com.lotto.primitive;

import java.util.Arrays;

public class LottoMake {
	private int[] lotto;

	public LottoMake() {
		this(6);
	}

	public LottoMake(int n) {
		lotto = new int[n];
	}

	// 랜덤숫자
	public int makeNum() {
		return (int) (Math.random() * 45 + 1);
	}

	// 중복판단
	/**
	 * 맴버필드의 배열에 입력한 Param값이 있는지 확인
	 * 
	 * @param int 랜덤숫자
	 * @return true 중복 / false 안중복
	 */
	public boolean check(int num) {
		boolean isc = false;
		for (int i = 0; i < lotto.length; i++) {
			if (lotto[i] == num) {
				isc = true;
				break;
			}
		}
		return isc;
	}
	
	public void lottoBall() {
		int idx = 0;
		while (idx < lotto.length) {
			// 랜덤번호 호출
			int n = makeNum();
			// 판단 ? 입력 : 다시
			if(!check(n)) {
				lotto[idx++] = n;
			}
		}
	}

	@Override
	public String toString() {
		return "LottoMake [lotto=" + Arrays.toString(lotto) + "]";
	}

	public int[] getLotto() {
		return lotto;
	}
	
	
}
