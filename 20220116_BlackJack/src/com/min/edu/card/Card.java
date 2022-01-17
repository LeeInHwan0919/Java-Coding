package com.min.edu.card;
/**
 * 패턴과 카드 값을 반환해오는 클래스
 * @author 집사들
 * 2022-01-16
 */
public class Card {
	private String pattern, cardVal; //문자열 타입 패턴과 카드값
	
	public Card(String pattern, String numVal) {
		this.pattern = pattern;
		this.cardVal = numVal;
	}

	public String getPattern() {
		return pattern;
	}

	public String getNumVal() {
		return cardVal;
	}
	
	@Override
	public String toString() {
		return String.format(" [%s%s] ", pattern, cardVal);
	}
	
}
