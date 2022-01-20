package com.min.game;

import java.util.ArrayList;

import com.min.card.Card;
import com.min.card.CardConvert;

/**
 * 버스트, 블랙잭, 총점 판단클래스
 * @author 쿼카
 * @since 2022-01-20
 */
public class Rule {
	
	/**
	 * 버스트를 판단하는 메소드 
	 * 카드 숫자값을 이용해 카드들의 점수 총합이 21을 초과하는지 아닌지 리턴
	 * @param hash 카드의 문자열과 숫자 값을 가지고 있는 배열
	 * @param cards 플레이어가 가지고 있는 카드 패
	 * @return true 버스트= 게임종료, false 버스트아님 = 게임진행
	 */
	public boolean isBust(CardConvert hash, ArrayList<Card> cards) {
		// 플레이어들이 가지고있는 패의 길이만큼 카드숫자 값을 총점에 더해준다.
		int cardSum = 0; //카드의 총합
		for (int i = 0; i < cards.size(); i++) {
			int[] value = new int[1];
			value = hash.getValue(cards.get(i));
			int num = value[0];
			cardSum += num;
		}
		if (cardSum > 21) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 카드들을 받아 블랙잭인지 아닌지 리턴
	 * @param cards 플레이어가 가지고 있는 카드패
	 * @return true
	 */
	public static boolean isBlackJack(ArrayList<Card> cards) {
		
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
	
	/**
	 * @param hash  카드의<문자열, 숫자> 값을 가지고있는 배열
	 * @param cards 플레이어가 가지고 있는 카드패
	 * @return 플레이어 패의 점수 총합
	 */
	public int Score(CardConvert hash, ArrayList<Card> cards) {

		int count = 0; 

		for (int i = 0; i < cards.size(); i++) {
			int[] value = new int[1];
			value = hash.getValue(cards.get(i));

			int num = value[0];
			count += num;
		}

		return count;
	}
}
