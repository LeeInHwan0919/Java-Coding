package com.min.game;

import java.util.HashMap;

// Card.java
public class Card {
	private String cardVal, strCard;

	Card(String strCard, String cardVal) {
		this.strCard = strCard;
		this.cardVal = cardVal;
	}

	
	public String getCardVal() {
		return cardVal;
	}


	public String getStrCard() {
		return strCard;
	}


	@Override
	public String toString() {
		return String.format("[%s%s]", strCard, cardVal);
	}

	
	
}