package BlackJack;

import java.util.ArrayList;

import com.min.game.Card;

// Player.java
public class CardReturn{
	private ArrayList<Card> cardHand = new ArrayList<Card>();

    public void addCard(Card card) {
        //(A) 드로우된 카드를 더해준다.
        cardHand.add(card);
    }
    
    public Card get(int idx) {
        //(B) 패에있는 카드를 리턴한다.
		return cardHand.get(idx);      		
	}
    
    public ArrayList<Card> getCardHand() {
        //(C) 모든 카드를 리턴한다.
  		return cardHand;
    }   
} 