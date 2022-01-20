package com.min.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * 카드덱을 생성하고 셔플,드로우 해주는 클래스
 * @author 쿼카
 * @since 2022-01-20
 */
public class CardCreate {
	private Stack<Card> cards = new Stack<Card>();
	ArrayList<Card> cardDeck = new ArrayList<Card>();

	/**
	 * A J Q K , 2-10 문자열 카드 배열 생성
	 * @param strCard 문자열 카드
	 */
	public void cardDeck_Create(String strCard) {
		cardDeck.add(new Card(strCard, "A"));
		cardDeck.add(new Card(strCard, "2"));
		cardDeck.add(new Card(strCard, "3"));
		cardDeck.add(new Card(strCard, "4"));
		cardDeck.add(new Card(strCard, "5"));
		cardDeck.add(new Card(strCard, "6"));
		cardDeck.add(new Card(strCard, "7"));
		cardDeck.add(new Card(strCard, "8"));
		cardDeck.add(new Card(strCard, "9"));
		cardDeck.add(new Card(strCard, "10"));
		cardDeck.add(new Card(strCard, "J"));
		cardDeck.add(new Card(strCard, "Q"));
		cardDeck.add(new Card(strCard, "K"));
	}

	// 문양마다 A J Q K , 2-10 생성
	public CardCreate() {
		cardDeck_Create("♣");
		cardDeck_Create("♦");
		cardDeck_Create("♥");
		cardDeck_Create("♠");
		// Collections Class에 있는 메소드로 List나 배열의 내용을 랜덤으로 보여줄 때 사용
		Collections.shuffle(cardDeck);
		// 셔플된 카드52개를 카드 스택에 쌓아주기
		// push = 카드 덱이 52장이 되기 전 까지 카드 추가
		for (int j = 0; j < 52; j++) {
			cards.push(cardDeck.get(j));
		}
	}

	// 카드를 한 장 받으면 카드를 스택에서 한 장 삭제
	// pop = 스택에서 한 장 제거
	public Card CardDraw() {
		return cards.pop();
	}
}