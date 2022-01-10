package com.goo.dee;

import java.util.Scanner;

/**
 * Goodee Academy Util
 * @author Lee In Hwan
 * @since 2022.01.05.
 */
public class GoodeeUtil {
	
	/**
	 * <b>java.util.Scanner</b> 객체를 사용하여 키보드로 입력받은 int를 반환하는 메소드
	 * @return
	 */
	public static int inputNum() {
		int n = 0;
		System.out.println("정수만 입력해 주세요");
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		System.out.println();
		return n;
	}
	
	/**
	 * <b>java.util.Scanner</b> 객체를 사용하여 키보드로 입력받은 String를 반환하는 메소드
	 * @return 문자열
	 */
	public static String inputString() {
		String str = "";
		Scanner scan = new Scanner(System.in);
		str = scan.next();
		return str;
	}
}
