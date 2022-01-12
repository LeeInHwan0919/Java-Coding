package com.min.edu;

import java.util.Arrays;
import java.util.StringTokenizer;

public class StringCut {

	/**
	 * java.lang.String.substring을 사용함
	 */
	public void substr() {
		String str = "Happy new Year";
		String strTmp = str.substring(6); // 문자열에서 인덱스의 6위치를 포함하여 뒤에 있는 모든 값을 가져온다.
		System.out.println(strTmp);

		String strTmp2 = str.substring(6, 9);
		System.out.println(strTmp2);

		String chk1 = "";
		String ch2 = null;
//		System.out.println((int)(chk1.substring(0).toCharArray()[0]));
//		System.out.println(chk1.charAt(0));
//		System.out.println(syschk1.hashCode());
		System.out.println(System.identityHashCode(chk1));
//		System.out.println(chk2.substring(0));

	}

	public void splitstr() {
		String str = "oop.and.foo";
		String[] strArr = str.split(""); // 정규화 표현식에서 없는값은 하나의 요소(unicode 값) 를 뜻한다.
		System.out.println(Arrays.toString(strArr));

		String[] strArr2 = str.split("[.]"); // 표현식으로 바꾸어서 처리 해야 함
		System.out.println(Arrays.toString(strArr2));

		String[] strArr3 = str.split("o");
		System.out.println("잘라지는 값의 갯수 : " + strArr3.length);
		System.out.println(Arrays.toString(strArr3));
	}

	public void stringToken() {
		// Iterator design pattern
		String str = "abc\tdef\thig";
		StringTokenizer st = new StringTokenizer(str);
		while (st.hasMoreElements()) { // SringTokenizer 객체에 객체가 있는지 확인함
			System.out.println("1: " + st.nextElement());
		}

		while (st.hasMoreElements()) { // SringTokenizer 객체에 객체가 있는지 확인함
			System.out.println("2: " + st.nextElement());
		}

		String str1 = "oop.and.foo"; // StringTokenizer는 empty값을 인정하지 않음
		StringTokenizer st2 = new StringTokenizer(str1, "o");
		while (st2.hasMoreTokens()) {
			System.out.println(st2.nextToken());
		}
		System.out.println("-----------------");
		String str2 = "\u3000\u3000p.and.f\u3000\u3000";
		System.out.println(Integer.toHexString((int) '　'));
		StringTokenizer st3 = new StringTokenizer(str2, "\u3000");
		while (st3.hasMoreTokens()) {
			System.out.println("3: " + st3.nextToken());
			
		}
	}
}
