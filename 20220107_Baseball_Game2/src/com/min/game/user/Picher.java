package com.min.game.user;

import java.util.Arrays;

/**
 * <b>숫자를 자동으로 생성해 주는 클래스</b>
 * 
 * @author Lee In Hwan
 *
 */
public class Picher extends GamerImpl {

	public Picher(int b) {
		super(b);
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
	@Override
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

}// class
