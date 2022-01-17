package com.min.edu.card;

import java.util.Arrays;
import java.util.Collections;

public class CardDeck extends CardImpl{

	

	private String[] randomcard = new String[ASCCARD.length];
	

	
	public String[] getRandomcard() {
		return randomcard;
	}

	public void Shuffle() {

//		for (int i = 0; i < cardarr.length; i++) { //for문사용 덱섞기
//			int num1 = (int) (Math.random() * cardarr.length);
//			int num2 = (int) (Math.random() * cardarr.length);
//			String temp = cardarr[num1];
//			cardarr[num1] = cardarr[num2];
//			cardarr[num2] = temp;
//		}
		Collections.shuffle(Arrays.asList(ASCCARD));//배열섞기 API
		System.out.println(Arrays.toString(ASCCARD));
	}
	
	public void cut() {
		for (int i = 0; i < ASCCARD.length; i++) {
			randomcard[i] = ASCCARD[i].substring(1);
		}
		System.out.println(Arrays.toString(randomcard));
		
	}

}
