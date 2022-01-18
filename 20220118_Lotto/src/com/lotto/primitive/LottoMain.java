package com.lotto.primitive;

import java.util.Arrays;

public class LottoMain {

	public static void main(String[] args) {
		// 생성자 오버로딩 this(6) > 맴버필드 초기화 new int[6]
		LottoMake lotto1 = new LottoMake(); 
		lotto1.lottoBall();
		System.out.println(lotto1);
		int[] lotto = lotto1.getLotto();
		System.out.println(Arrays.toString(lotto));
	}

}
