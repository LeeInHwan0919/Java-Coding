package com.card.game;

import java.util.Arrays;
import java.util.List;

public class CardMain {

	public static void main(String[] args) {
//		LottoNum one = new LottoNum();
//		System.out.println(one);
		CardCase make = new CardCase();
		List<CardOne> allCard = make.getCardcase();

		System.out.println(allCard);
		CardOne[] user1 = new CardOne[3];
		for (int i = 0; i < user1.length; i++) {
			user1[i] = allCard.get(0);
			allCard.remove(0);
		}
		System.out.println("user1나눠줌 : " + Arrays.toString(user1));
		System.out.println("나머지 카드");
		System.out.println(make.getCardcase());
		
		String card0 = user1[0].toString();
		String[] cardSplit = card0.split("");
		System.out.println(Arrays.toString(cardSplit));
	}

}
