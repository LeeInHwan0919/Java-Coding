package BlackJack;

import java.util.*;

// CardPool.java
public class CardPool {
    private Stack<Card> cards = new Stack<Card>();
    
    ArrayList<Card> Deck = new ArrayList<Card>(); // 덱 생성 후 셔플을 위한 ArrayList 생성
    public void Deck_Create(String suit){ // 덱 생성 메소드
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
    //(D) deckEa개의 덱을 생성하고 셔플한 후 추가한다.
    	for(int i=0; i < deckEa ; i++) { // 덱 생성
    	    Deck_Create("Clubs");    	
         	Deck_Create("Diamonds");    	
         	Deck_Create("Hearts");    	
        	Deck_Create("Spades");
    	}
        Collections.shuffle(Deck); // 셔플
        for(int j=0; j<(deckEa*52); j++) { // 셔플한 덱의 카드들을 Stack에 push
             	cards.push(Deck.get(j));
        } 	
    }
    
    public Card drawCard(){
    //(E) 카드들로 부터 카드를 한장 뽑는다.
    	return cards.pop(); // Stack의 카드들로 부터 한장씩 pop
    }
}