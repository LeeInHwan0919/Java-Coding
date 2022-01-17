package com.min.edu.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
/**
 * 카드덱을 생성하고 셔플한다
 * Stack 클래스와 ArrayList 클래스를 사용
 * 카드를 한 장 받으면 한 장 제거해준다
 * @author 집사들
 * 2022-01-06
 */
public class CardDeck {
	private Stack<Card> cards = new Stack<Card>();
	ArrayList<Card> Deck = new ArrayList<Card>();// 덱 생성 후 셔플을 위한 ArrayList 생성
	public void DeckCreate(String pattern) {
	Deck.add(new Card(pattern, "A"));
	Deck.add(new Card(pattern, "2"));
	Deck.add(new Card(pattern, "3"));
	Deck.add(new Card(pattern, "4"));
	Deck.add(new Card(pattern, "5"));
	Deck.add(new Card(pattern, "6"));
	Deck.add(new Card(pattern, "7"));
	Deck.add(new Card(pattern, "8"));
	Deck.add(new Card(pattern, "9"));
	Deck.add(new Card(pattern, "10"));
	Deck.add(new Card(pattern, "J"));
	Deck.add(new Card(pattern, "Q"));
	Deck.add(new Card(pattern, "K"));
	}
	
	public CardDeck(int n) { //n개의 덱을 생성하고 셔플
		for (int i = 0; i < n; i++) { //덱 생성
			DeckCreate("♣"); //클로버
			DeckCreate("◆"); //다이아
			DeckCreate("♥"); //하트
			DeckCreate("♠"); //스페이드
		}
		Collections.shuffle(Deck);
		for (int j = 0; j < n*52; j++) { //셔플한 덱의 카드들을 stack에 넣어줌
			cards.push(Deck.get(j));//push는 스택에 값을 추가
		}
	}
	public Card drawCard() { //카드 타입을 받는다 = 한장씩 뽑는다
		return cards.pop(); // pop = 스택에 값 제거 = 한장씩 제거한다
	}
	
}
