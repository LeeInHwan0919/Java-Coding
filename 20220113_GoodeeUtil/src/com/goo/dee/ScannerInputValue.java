package com.goo.dee;

import java.util.Scanner;

/**
 *  수업에서 사용하는 정수만을 입력 받을 수 있는 예외처리된 클래스
 * @author GDJ44
 * @since 2022.01.13
 */
public class ScannerInputValue {
	// 예외 처리를 시스템의 멈춤 없이 진행 될 수 있도록 도와 준다.~~!!!! 중요

	// 숫자를 입력받는데, 문자를 입력하면 nextInt()에 의해서 InputMisMatchException이 발생함
	// 예외처리를 통해서 원하는 정확한 정수를 입력 받을 때까지 처리 하고 싶습니다.

	/**
	 * 정수 이외의 값을 입력할 경우 예외처리 하였음<br>
	 * while문을 통해서 정확한 정수값을 입력해야만 메소드가 종료됨
	 * @return  키보드로 입력한 정수값
	 */
	public static int inputInteger() {
		int num = 0;
		while (true) {
			try {
				Scanner scan = new Scanner(System.in);
				System.out.println("정수를 입력해 주세요");
				num = scan.nextInt();
				break;
			} catch (Exception e) {
				System.out.println(e.toString());
			} finally {
				System.out.println("입력받았음");
			} 
		}
		return num;
	}
}
