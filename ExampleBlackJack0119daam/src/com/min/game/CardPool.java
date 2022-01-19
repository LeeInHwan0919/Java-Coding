package com.min.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

// CardPool.java
public class CardPool {
    private Stack<BlackJackImpl> cards = new Stack<BlackJackImpl>();
    
    ArrayList<BlackJackImpl> Deck = new ArrayList<BlackJackImpl>(); // 
    public void Deck_Create(String suit){ //
    	Deck.add(new BlackJackImpl(suit, "A"));
    	Deck.add(new BlackJackImpl(suit, "2"));
    	Deck.add(new BlackJackImpl(suit, "3"));
    	Deck.add(new BlackJackImpl(suit, "4"));
    	Deck.add(new BlackJackImpl(suit, "5"));
    	Deck.add(new BlackJackImpl(suit, "6"));
    	Deck.add(new BlackJackImpl(suit, "7"));
    	Deck.add(new BlackJackImpl(suit, "8"));
    	Deck.add(new BlackJackImpl(suit, "9"));
    	Deck.add(new BlackJackImpl(suit, "10"));
    	Deck.add(new BlackJackImpl(suit, "J"));
    	Deck.add(new BlackJackImpl(suit, "Q"));
    	Deck.add(new BlackJackImpl(suit, "K"));
    }
    
    CardPool(int deckEa){
    //(D) 
    	for(int i=0; i < deckEa ; i++) { // 
    	    Deck_Create("♣");    	
         	Deck_Create("◆");    	
         	Deck_Create("♥");    	
        	Deck_Create("♠");
    	}
        Collections.shuffle(Deck);
        for(int j=0; j<(deckEa*52); j++) {
             	cards.push(Deck.get(j));
        } 	
    }
    
    public BlackJackImpl drawCard(){
    //(E) 
    	return cards.pop(); // Stack
    }
}