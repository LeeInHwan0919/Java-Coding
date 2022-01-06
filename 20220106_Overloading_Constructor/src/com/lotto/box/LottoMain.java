package com.lotto.box;

import java.util.Arrays;

public class LottoMain {

	public static void main(String[] args) {
		LottoOne lotto = new LottoOne(15);// 6개의 배열이 만들어 지고 자도으로 45숫자중 중복 없이 만들어 짐.
		int[] result = lotto.getLotto_one();
		System.out.println(Arrays.toString(result));
	}

}
