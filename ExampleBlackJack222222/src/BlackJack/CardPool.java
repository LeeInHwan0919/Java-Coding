package BlackJack;

import java.util.*;

// CardPool.java
public class CardPool {
    private Stack<Card> cards = new Stack<Card>();
    
    ArrayList<Card> Deck = new ArrayList<Card>(); // 
    public void Deck_Create(String suit){ //
    	Deck.add(new Card(suit, "A"));
    	Deck.add(new Card(suit, "2"));
    	Deck.add(new Card(suit, "3"));
    	Deck.add(new Card(suit, "4"));
    	Deck.add(new Card(suit, "5"));
    	Deck.add(new Card(suit, "6"));
    	Deck.add(new Card(suit, "7"));
    	Deck.add(new Card(suit, "8"));
    	Deck.add(new Card(suit, "9"));
    	Deck.add(new Card(suit, "10"));
    	Deck.add(new Card(suit, "J"));
    	Deck.add(new Card(suit, "Q"));
    	Deck.add(new Card(suit, "K"));
    }
    
    CardPool(int deckEa){
    //(D) 
    	for(int i=0; i < deckEa ; i++) { // 
    	    Deck_Create("Clubs");    	
         	Deck_Create("Diamonds");    	
         	Deck_Create("Hearts");    	
        	Deck_Create("Spades");
    	}
        Collections.shuffle(Deck);
        for(int j=0; j<(deckEa*52); j++) {
             	cards.push(Deck.get(j));
        } 	
    }
    
    public Card drawCard(){
    //(E) 
    	return cards.pop(); // Stack
    }
}