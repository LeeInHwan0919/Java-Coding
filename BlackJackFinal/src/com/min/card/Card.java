package com.min.card;

/**
 * 문자열 카드와 숫자 카드 반환해주는 클래스
 * @author 쿼카
 * @since 2022-01-20
 */
public class Card {
	//멤버필드 선언
	private String cardVal, strCard;
	
	/**
	 * 멤버필드 호출
	 * @param strCard 문자열 카드
	 * @param cardVal 숫자 카드
	 */
	Card(String strCard, String cardVal) {
		this.strCard = strCard;
		this.cardVal = cardVal;
	}

	//멤버필드 Getter
	public String getCardVal() {
		return cardVal;
	}

	
	public String getStrCard() {
		return strCard;
	}

	//toString 오버라이드
	@Override
	public String toString() {
		return String.format("[%s%s]", strCard, cardVal);
	}

	
	
}