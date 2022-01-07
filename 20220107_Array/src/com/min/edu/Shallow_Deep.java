package com.min.edu;

import java.util.Arrays;

public class Shallow_Deep {

	/*
	 * 같은 값을 유지하고 있는 다른 객체
	 */
	public void deep() {
		String[] strs = new String[] { "d", "r", "e", "a", "m" };
		// stack 필수
		String[] strsCopy = new String[strs.length];
		for (int i = 0; i < strsCopy.length; i++) {
			strsCopy[i] = strs[i];
		}
		// heap 필수 java.lang.Object 자식이 복제될 수 있도록 해주는 protected clone
		String[] strsCopy2 = strs.clone();

		// 메모리 사용하는 방법 모르셔도됨. java.lang.System
		String[] strsCopy3 = new String[10];
		System.arraycopy(strs, 0, strsCopy3, 3, 3);

		System.out.println("strsCopy" + Arrays.toString(strsCopy));
		System.out.println("strsCopy" + Arrays.toString(strsCopy2));
		System.out.println("strsCopy" + Arrays.toString(strsCopy3));
		
		System.out.println("strshash" + strs.hashCode());
		System.out.println("strshash" + strsCopy.hashCode());
		System.out.println("strshash" + strsCopy2.hashCode());
		System.out.println("strshash" + strsCopy3.hashCode());
	}

	public void shallow() {
		// pass by reference : 참조타입의 특징 주소를 전달 하는 방식
		int[] arr = { 1, 2, 3, 4 };
		int[] cArr = arr;
		// java.lang.Object를 사용한다.
		System.out.println(arr == cArr); // == 기본타입 값, 참조타입 주소
		System.out.println(arr.equals(cArr)); // 같은 hashcode를 가지고 있는지 확인

		System.out.println("원본 " + Arrays.toString(arr));
		System.out.println("원본 " + Arrays.toString(cArr));

		cArr[2] = 99;

		System.out.println("원본 " + Arrays.toString(arr));
		System.out.println("원본 " + Arrays.toString(cArr));

		String str = "lucas@gmail.com"; // 문자열인 String 문자형 char의 조합
		char[] c = { 'h', 'a', 'p', 'p', 'y' };
		String cToS = new String(c);
		System.out.println(cToS); // happy
		cToS = cToS.substring(3);
		System.out.println(cToS);
	}
}
