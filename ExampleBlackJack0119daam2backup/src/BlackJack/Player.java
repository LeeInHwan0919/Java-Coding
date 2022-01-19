package BlackJack;

import java.util.ArrayList;

import com.min.game.BlackJackImpl;

// Player.java
public class Player{
	private ArrayList<BlackJackImpl> hand = new ArrayList<BlackJackImpl>();

    public void addCard(BlackJackImpl card) {
        //(A) 
        hand.add(card);
    }
    
    public BlackJackImpl get(int item) {
        //(B) item
		return hand.get(item);      		
	}
    
    public ArrayList<BlackJackImpl> getHand() {
        //(C) 
  		return hand;
    }   
} 