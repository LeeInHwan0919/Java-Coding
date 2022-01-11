package com.min.game.user;

import java.util.Arrays;

public abstract class GamerImpl implements IGamer {//abstract(추상화)메소드가 있다면 추상화 클래스로 만들어 주어야 한다.
	
	protected int[] box;
	
	public GamerImpl(int n) {
			box = new int[n];
			Arrays.fill(box, -1);
	}
	
	@Override
	public void print() {
		System.out.printf("[");
		for (int i = 0; i < box.length - 1; i++) {
			System.out.printf("%s,", box[i]);
		}
		System.out.printf("%s]", box[box.length - 1]);
	}

	@Override
	public abstract void make();

	//멤버필드 가져가야하니깐 자식에게 게터
	public int[] getBox() {
		return box;
	}


}
