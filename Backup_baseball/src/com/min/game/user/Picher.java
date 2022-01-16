package com.min.game.user;

import java.util.Arrays;

/**
 * <b>숫자를 자동으로 생성해 주는 클래스</b>
 * 
 * @author Lee In Hwan
 *
 */
public class Picher {

	private int[] box;

//	public Picher() {
//		this(3);
//	}

	public Picher(int b) {
		box = new int[b];
		Arrays.fill(box, -1);
	}

	public int[] getBox() {
		return box;
	}

	// 난수를 발생
	private int makeNum() {
		int num = 0;
		num = (int) (Math.random() * 9) + 1;
		return num;
	}

	// 중복값 확인
	/**
	 * 멤버필드의 중복 값을 확인함
	 * 
	 * @param tmp 랜덤숫자
	 * @return true 중복 /false 사용
	 */
	public boolean isDuplicate(int tmp) {
		boolean isc = false;
		for (int i = 0; i < box.length; i++) {
			if (box[i] == tmp) {
				isc = true;
			}
			break;
		}
		return isc;
	}

	// 배열에 값을 채워줌,
	public void make() {
		int idx = 0;
		int n = box.length;
		while (idx != n) { // =while( true) if문 (idx == n) break;
			int num = makeNum();
			if (!isDuplicate(num)) { //
				this.box[idx++] = num;// 멤버필드에서는 this를 사용해주어야 한다.(부모거는 super)
			} // if
		} // while
	}// make

	// 부모의 toString 을 자식이 재정의 하여 사용한다.
	// 부모의 기능을 사용하지 못하고 자식의 재정의된 메소드로 실행 된다.
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

}// class
