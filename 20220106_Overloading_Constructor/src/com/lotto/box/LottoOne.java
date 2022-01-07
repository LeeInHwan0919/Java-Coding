package com.lotto.box;

/**
 * 로또 한줄을 생성하는 클래스
 * 
 * @author Lee In Hwan
 *
 */
public class LottoOne {

	private int[] lotto_one;

	public LottoOne() {
		this(6);
	}

	public LottoOne(int n) {
		lotto_one = new int[n];
		lottoMake();
	}

	public int[] getLotto_one() {
		return lotto_one;
	}

	public void setLotto_one(int[] lotto_one) {
		this.lotto_one = lotto_one;
	}

	private void lottoMake() {
		int idx = 0; //입력하는 배열의 index값
		while (true) {
			int rNum = (int)(Math.random()*45)+1;
			if(!isCheck(rNum)) {
				lotto_one[idx++] = rNum;
			}
			if(idx == lotto_one.length) {
				break;
			}
		}
	}

	private boolean isCheck(int rNum) {
		boolean isc = false;
		for (int i = 0; i < lotto_one.length; i++) {
			if(lotto_one[i] == rNum) {
				isc = true;
				break;
			}
		}
		return isc;
	}
}
