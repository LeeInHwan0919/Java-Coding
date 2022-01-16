package com.min.edu.card;

import java.util.Arrays;
import java.util.Collections;

public class CardDeck {

	private String[] cardarr = { "♠1", "♠2", "♠3", "♠4", "♠5", "♠6", "♠7", "♠8", "♠9", "♠10", "♠11", "♠12", "♠13", "♥1",
			"♥2", "♥3", "♥4", "♥5", "♥6", "♥7", "♥8", "♥9", "♥10", "♥11", "♥12", "♥13", "♣1", "♣2", "♣3", "♣4", "♣5",
			"♣6", "♣7", "♣8", "♣9", "♣10", "♣11", "♣12", "♣13", "◆1", "◆2", "◆3", "◆4", "◆5", "◆6", "◆7", "◆8", "◆9",
			"◆10", "◆11", "◆12", "◆13" };
	private int[] backarr = new int[cardarr.length];

	public void test() {
		System.out.println(Arrays.toString(cardarr));
	}


	public void Shuffle() {

//		for (int i = 0; i < cardarr.length; i++) {
//			int num1 = (int) (Math.random() * cardarr.length);
//			int num2 = (int) (Math.random() * cardarr.length);
//			String temp = cardarr[num1];
//			cardarr[num1] = cardarr[num2];
//			cardarr[num2] = temp;
//		}
		Collections.shuffle(Arrays.asList(cardarr));
		System.out.println(Arrays.toString(cardarr));
	}

}
