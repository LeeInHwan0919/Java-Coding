package com.min.game.user;

import java.util.Arrays;
import java.util.regex.Pattern;
import lee.iin.han.lih_Util;

public class Hitter {

	private int[] box;

//	public Hitter() {
//		this(3);
//	}

	public Hitter(int n) {
		box = new int[n];
		Arrays.fill(box, -1);
	}

	public int[] getBox() {
		return box;
	}

	// 테스트를 위한 값을 입력 하기 위해서 사용
//	public void setBox(int[] box) {
//		this.box = box;
//	}

	public int[] makeNum() {
		int[] tmp = new int[box.length];
		System.out.println("정수 3개를 붙여서 입력해 주세요");
		String str = lih_Util.inputString();// 대상 문자열
		System.out.println("입력하신 숫자는! " + str);
		// 정규화 표현식 문자열 검증 java.util.regex.Pattern matches()
		// 숫자만 입력 받을거다.
		String pattern = "^[1-9]*$";// 검증 문자열
//		String inVal = "012";// 대상 문자열
		boolean regex = Pattern.matches(pattern, str);
//		System.out.println("입력 받은 값이 1~9까지의 숫자입니까? " + regex);

		// 비교판단 및 유효성을 검사해서 다시 입력을 받을 건지, 정확한 값
		// 입력값이 없거나 길이가 체워야할 배열과 같지 않거나 숫자로만 구성이 되어있지 않다면
		// 다시 입력 받아야 한다.
		while (str.trim().equals("") || str.trim().length() != box.length || !Pattern.matches(pattern, str)) {
			System.out.println("다시 입력해 주세요");
			str = lih_Util.inputString();
		}

		for (int i = 0; i < tmp.length; i++) {
//			tmp[i] = str.charAt(i); // '1' -'0'
			tmp[i] = Character.getNumericValue(str.charAt(i));
		}

		return tmp;
	}

	/**
	 * 같은 값을 가지고 있는 배열의 값이 있다면 true
	 * 
	 * @return true중복 / false 사용
	 */
	private boolean isSame() {
		boolean isc = false;
		int n = box.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i != j && box[i] == box[j]) {
					isc = true;
				}
			}
		}
		return isc;
	}

	public void make() {
		int n = box.length;
		System.arraycopy(makeNum(), 0, box, 0, n);
		while(true) {
			if(isSame()) {
				System.out.println("중복이 되었습니다. 중복 없이 입력해 주세요");
				System.arraycopy(makeNum(), 0, box, 0, n);
			}else {
				break;
			}
		}
		
	}

	@Override // just 표기
	public String toString() { // 반환타입이 있는 메소드
//		System.out.println(super.toString());// 자식이 부모에게 요청, 내것을 호출할 때는 this
//		return "Picher [box=" + Arrays.toString(box) + "]";

		String s = "[";
		int n = box.length; // 배열(length), 문자열(length()), JCF(size())
		for (int i = 0; i < n - 1; i++) {
			s += String.format("%s", box[i]);
		}
		s += String.format("%s]", box[n - 1]);
		return s;
	}
	
	public void print() {
		System.out.printf("[");
		for (int i = 0; i < box.length - 1; i++) {
			System.out.printf("%s,", box[i]);
		}
		System.out.printf("%s]", box[box.length - 1]);
	}

}
