package com.min.game;

// Card.java
public class BlackJackImpl {
	private String rank, suit;

	BlackJackImpl(String suit, String rank) {
		this.suit = suit;
		this.rank = rank;
	}

	public String getSuit() {
		return suit;
	}

	public String getRank() {
		return rank;
	}
	@Override
	public String toString() {
		return String.format("[%s%s]", suit, rank);
	}
}