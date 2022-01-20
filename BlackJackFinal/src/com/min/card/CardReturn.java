package com.min.card;

import java.util.ArrayList;

/**
 * 패의 카드를 더해주거나 리턴해주는 메소드 
 * @author 쿼카
 * @since 2022-01-20
 */

public class CardReturn {
	private ArrayList<Card> cardHand = new ArrayList<Card>();

	public void addCard(Card card) {
		// 드로우된 카드를 더해준다.
		cardHand.add(card);
	}

	public Card get(int idx) {
		// 패에있는 카드를 리턴한다.
		return cardHand.get(idx);
	}

	public ArrayList<Card> getCardHand() {
		// 모든 카드를 리턴한다.
		return cardHand;
	}
}