package com.min.edu.game;

import java.util.HashMap;
/**
 * 카드에 값을 정해주는 클래스
 * HashMap을 사용
 * @author 집사들
 * 2022-01-06
 */
public class CardValue {
	private HashMap<String, int[]> table = new HashMap<>();
	
	public void setValue(String strPattern, int cardVal) {
		String strpattern = strPattern;
		int[] value = new int[1];
		value[0] = cardVal;
		table.put(strpattern, value);
	}
	
	public CardValue() {
		setValue("A", 1);
		setValue("2", 2);
		setValue("3", 3);
		setValue("4", 4);
		setValue("5", 5);
		setValue("6", 6);
		setValue("7", 7);
		setValue("8", 8);
		setValue("9", 9);
		setValue("10", 10);
		setValue("J", 11);
		setValue("Q", 12);
		setValue("K", 13);
	}
	
}
