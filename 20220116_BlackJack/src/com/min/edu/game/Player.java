package com.min.edu.game;

import java.util.Vector;

import com.min.edu.card.Card;
/**
 * 카드를 추가해주는 메소드
 * n번째 카드를 리턴하거나 모든 패를 리턴
 * @author 집사들
 * 2022-01-17
 */


// Player.java
public class Player{
    private Vector<Card> hand = new Vector<Card>();

    public void addCard(Card card) {
        //(A) 카드를 추가한다.
        hand.add(card);
    }
    
    public Card get(int item) {
        //(B) item번째 카드를 리턴한다.
		return hand.get(item);      		
	}
    
    public Vector<Card> getHand() {
        //(C) 가지고 있는 패를 모두 리턴한다.
  		return hand;
    }   
} 
