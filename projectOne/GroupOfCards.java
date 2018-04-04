package blackJack;

import java.util.LinkedList;
import java.util.Queue;

public class GroupOfCards {
    Queue<Card> cards = new LinkedList<Card>();
    Queue<Card> dealCards = new LinkedList<Card>();
    
//    int topCards= 0;
    
    GroupOfCards(){};
    
    GroupOfCards(int num){};

    void addCard(Card c){
    	cards.add(c);
    };

    void discardAll(){
    	cards = null;
    };
    

    int getCurrentSize(){
    	return cards.size();
    }
    

    void display(){
    	for (Card card:cards) {
    		System.out.println(card.toString());
    	}
    }
    //EFFECTS: display every card in cards;

    Card deleteCard(){
    	Card card = cards.poll();
    	dealCards.add(card);
    	return card;
    };
    // EFFECTS: delete the top card from the group of cards and return the
    // deleted card value;
}
