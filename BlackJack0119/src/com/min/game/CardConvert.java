package com.min.game;

import java.util.HashMap;

// ScoreTable.java
public class CardConvert {
	private HashMap<String, int[]> hash = new HashMap<>();

	public void Hash_Create(String strCard, int cardVal) {
		String key = strCard;
		int[] value = new int[1];
		value[0] = cardVal;
		hash.put(key, value);
	}

	CardConvert() {
		// (F) key=: value=

		String key = "A"; // "A"
		int[] value = new int[2];
		value[0] = 1;
		value[1] = 11;
		hash.put(key, value);

		Hash_Create("2", 2);
		Hash_Create("3", 3);
		Hash_Create("4", 4);
		Hash_Create("5", 5);
		Hash_Create("6", 6);
		Hash_Create("7", 7);
		Hash_Create("8", 8);
		Hash_Create("9", 9);
		Hash_Create("10", 10);
		Hash_Create("J", 10);
		Hash_Create("Q", 10);
		Hash_Create("K", 10);
	}

	public int[] isA(Card card) {
		// (G) card

		if (card.getCardVal().equals("A")) { // "A"
			int[] value = new int[2];
			value[0] = 1;
			value[1] = 11;
			return value;
		} else {
			int[] value = new int[1];
			value = hash.get(card.getCardVal()); //
			return value;
		}
	}
}