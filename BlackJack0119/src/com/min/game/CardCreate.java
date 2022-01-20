package com.min.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

// CardPool.java
public class CardCreate {
    private Stack<Card> cards = new Stack<Card>();
    
    ArrayList<Card> cardDeck = new ArrayList<Card>(); // 
    public void cardDeck_Create(String strCard){ //
    	cardDeck.add(new Card(strCard, "A"));
    	cardDeck.add(new Card(strCard, "2"));
    	cardDeck.add(new Card(strCard, "3"));
    	cardDeck.add(new Card(strCard, "4"));
    	cardDeck.add(new Card(strCard, "5"));
    	cardDeck.add(new Card(strCard, "6"));
    	cardDeck.add(new Card(strCard, "7"));
    	cardDeck.add(new Card(strCard, "8"));
    	cardDeck.add(new Card(strCard, "9"));
    	cardDeck.add(new Card(strCard, "10"));
    	cardDeck.add(new Card(strCard, "J"));
    	cardDeck.add(new Card(strCard, "Q"));
    	cardDeck.add(new Card(strCard, "K"));
    }

    CardCreate(int i){
    //(D) 
    	    cardDeck_Create("♣");    	
         	cardDeck_Create("♦");    	
         	cardDeck_Create("♥");    	
        	cardDeck_Create("♠");
        Collections.shuffle(cardDeck);
        
        for(int j=0; j<52; j++) {
             	cards.push(cardDeck.get(j));
        } 	
    }
    
    public Card CardDraw(){
    //(E) 
    	return cards.pop(); // Stack
    }
}