package com.min.game.play;

/*
 *	두개의 box(pitcher, Hitter)를 받아서 get 메소드를 통해서 결과를 반환함
 * 	strike	:	같은	index 같은 값
 * ball	:	다른 index 같은 값
 */
public class Umpire {

	private int[] pBox;	//	참조타입의 초기화는 null
	private int[] hBox;
//	private int boxLength;

//	public Umpire() {
//		this(3);
//	}
//
//	public Umpire(int n) {
//		this.boxLength = n;
//		pBox = new int[n];
//		hBox = new int[n];
//	}
//
//	public Umpire(int[] pBox, int[] hBox) {
//		super();
//		this.pBox = pBox;
//		this.hBox = hBox;
//		this.boxLength = pBox.length;
//	}

	public void setpBox(int[] pBox) {
		this.pBox = pBox;
	}

	public void sethBox(int[] hBox) {
		this.hBox = hBox;
	}

	// Strike 갯수를 반환
	public int getStrike() {
		int cnt = 0;
		for (int i = 0; i < pBox.length; i++) {
			if (pBox[i] == hBox[i]) {
				cnt++;
			}
		}
		return cnt;
	}

	// Ball 갯수를 반환
	public int getBall() {
		int cnt = 0;
		for (int i = 0; i < pBox.length; i++) {
			for (int j = 0; j < hBox.length; j++) {
				if (i != j && pBox[i] == hBox[j]) {
					cnt++;
				}
			}
		}
		return cnt;
	}
}
