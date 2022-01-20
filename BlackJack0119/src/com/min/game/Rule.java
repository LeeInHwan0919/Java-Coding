package com.min.game;

import java.util.ArrayList;

public class Rule {
	public static boolean dealer = true;

	public static boolean isBust(CardConvert hash, ArrayList<Card> cards) {
		// (I) hash 이용해 card 들의 점수 총합이 21을 초과하는지 아닌지 리턴
		int cardSum = 0; // 카드의 총합
		int aCard = 0; // A카드를 필요에 따라 1또는 11의 값으로 변경하기 위한 변수

		if (dealer == true) {
			for (int i = 0; i < cards.size(); i++) {
				int[] value = new int[2];
				value = hash.isA(cards.get(i));

				if (value[0] == 1 && aCard == 0 && (i == 0 || i == 1)) { // 처음 2개의 패 중 1개의 "A"만 있을 경우
					int num11 = value[1]; // "11"
					cardSum += num11;
					aCard++;
				}

				else {
					int num = value[0];
					cardSum += num;
				}
			}
		}

		if (dealer == false) {
			for (int i = 0; i < cards.size(); i++) {
				int[] value = new int[2];
				value = hash.isA(cards.get(i));

				if (value[0] == 1) { // "A"일 경우(동시에 "A"임을 증명)
					int num1 = value[0]; // "1"
					int num11 = value[1]; // "11"

					if (cardSum > 10) {
						cardSum += num1;
						if (cardSum > 21 && aCard == 1) {
							cardSum = cardSum - 10;
							aCard = 0;
						}
					} else {
						cardSum += num11;
						aCard++;
					}
				} else { // "A"가 아닐경우
					int num = value[0];
					cardSum += num;
					if (cardSum > 21 && aCard == 1) {
						cardSum = cardSum - 10;
						aCard = 0;
					}
				}
			}
		}

		if (cardSum > 21) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isBlackJack(ArrayList<Card> cards) {
		// (J) 카드들을 받아 블랙잭인지 아닌지 리턴

		String str1 = cards.get(0).getCardVal();
		String str2 = cards.get(1).getCardVal();

		// 패의 2개의 카드 중 하나가 A이고 다른 하나가 10,J,Q,K일 경우 블랙잭
		if (str1.equals("A") && (str2.equals("10") || str2.equals("J") || str2.equals("Q") || str2.equals("K"))) {
			return true;
		} else if (str2.equals("A")
				&& (str1.equals("10") || str1.equals("J") || str1.equals("Q") || str1.equals("K"))) {
			return true;
		} else {
			return false;
		}
	}

	public int Score(CardConvert hash, ArrayList<Card> cards) {
		// (H) hash 이용해 card 들의 점수 총합을 리턴
		int count = 0; // 카드의 총합
		int aCard = 0; // A카드를 필요에 따라 1또는 11의 값으로 변경하기 위한 변수

		if (dealer == true) {
			for (int i = 0; i < cards.size(); i++) {
				int[] value = new int[2];
				value = hash.isA(cards.get(i));

				if (value[0] == 1 && aCard == 0 && (i == 0 || i == 1)) { // 처음 2개의 패 중 1개의 "A"만 있을 경우
					int num11 = value[1]; // "11"
					count += num11;
					aCard++;
				}

				else {
					int num = value[0];
					count += num;
				}
			}
		}

		if (dealer == false) {
			for (int i = 0; i < cards.size(); i++) {
				int[] value = new int[2];
				value = hash.isA(cards.get(i));

				if (value[0] == 1) { // "A"일 경우(동시에 "A"임을 증명)
					int num1 = value[0]; // "1"
					int num11 = value[1]; // "11"

					if (count > 10) {
						count += num1;
						if (count > 21 && aCard == 1) {
							count = count - 10;
							aCard = 0;
						}
					} else {
						count += num11;
						aCard++;
					}
				} else { // "A"가 아닐경우
					int num = value[0];
					count += num;
					if (count > 21 && aCard == 1) {
						count = count - 10;
						aCard = 0;
					}
				}
			}
		}

		return count;
	}
}