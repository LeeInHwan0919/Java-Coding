package com.min.card;

import java.util.HashMap;

/**
 * 문자열 카드를 Integer값으로 변경해주는 클래스
 * @author 쿼카
 * @since 2022-01-20
 */
public class CardConvert {

	private HashMap<String, int[]> hash = new HashMap<>();

	/**
	 * HashMap을 이용해 Key 값에는 문자열 / Value 값에는 숫자 배열값을 넣어줌
	 * @param strCard 문자열 카드
	 * @param cardVal 숫자열 카드
	 */
	public void Hash_Create(String strCard, int cardVal) {
		String key = strCard;
		int[] value = new int[1];
		value[0] = cardVal;
		hash.put(key, value);
	}

	// HashMap에 Key, Value 상세값을 넣어주는 메소드
	public CardConvert() {
		String key = "A";
		int[] value = new int[1];
		hash.put(key, value);

		Hash_Create("A", 11);
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

	/**
	 * 카드를 숫자값으로 반환하는 메소드
	 * @param card 문자열 카드
	 * @return 카드의 숫자값을 가져옴
	 */
	public int[] getValue(Card card) {
			int[] value = new int[1];
			value = hash.get(card.getCardVal()); //
			return value;
	}
}