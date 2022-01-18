package BlackJack;

import java.util.ArrayList;

// Player.java
public class Player{
	private ArrayList<Card> hand = new ArrayList<Card>();

    public void addCard(Card card) {
        //(A) 
        hand.add(card);
    }
    
    public Card get(int item) {
        //(B) item
		return hand.get(item);      		
	}
    
    public ArrayList<Card> getHand() {
        //(C) 
  		return hand;
    }   
} 