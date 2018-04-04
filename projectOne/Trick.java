package blackJack;

import java.util.Queue;

public class Trick {
	Deck deck;
    Player player;
    Dealer dealer;
    int bet;

    Trick(String type, int bankroll, int minimum){
    	if (type.equals("simple")) {
    		player = new SimplePlayer(bankroll, minimum);
    	}else {
    		player = new CountingPlayer(bankroll, minimum);
    	}
    	dealer = new Dealer();
    	deck = new Deck();
    	
    };

    void play(){

    }
    // execute the five following steps;

    void wager(){
    };

    void DealFour(){
    	Queue<Card> cardList = deck.cards;
    	Queue<Card> dealCardList = deck.dealCards;
    	
    	for (int i = 0; i < 4;i++) {	
    		Card card = cardList.poll();
    		if (i % 2 == 0) {
    			player.hand.addCard(card);
    	    	System.out.println("Player dealt " + card.toString());
    	    	player.expose(card);
    		} else {
    			dealer.hand.addCard(card);
    			if (i == 1) {
    				dealer.firstCard = card;
    				System.out.println("Dealer dealt " + card.toString());
    				player.expose(card);
    			} else if (i==3) {
    				dealer.holeCard = card;
    				
    			}
    			
    		}
    		dealCardList.add(card);
    	}
    	
    };
    //After the wager, the dealer deals a total of four cards:
    // the first face-up to the player, the second face-up to
    // himself, the third face-up to the player, and the fourth
    // face-down to himself.

    void playerTurn(){
    	Queue<Card> cardList = deck.cards;
    	Queue<Card> dealCardList = deck.dealCards;
    	Card next = cardList.poll();
    	player.hand.addCard(next);
    	System.out.println("Player dealt " + next.toString());
    	player.expose(next);
    	dealCardList.add(next);
    	
    };

    void dealerTurn(){
    	Queue<Card> cardList = deck.cards;
    	Queue<Card> dealCardList = deck.dealCards;
    	Card next = cardList.poll();
    	dealer.hand.addCard(next);
    	System.out.println("Dealer dealt " + next.toString());
    	player.expose(next);
    	dealCardList.add(next);
    };

    // dealer's turn only happens if the player hasn’t busted or the player is
    // not dealt a natural 21 .

    void closeTurn(int bet){
    	int sum1 = player.hand.sum();
    	int sum2 = dealer.hand.sum();
    	if (sum1 > sum2) {
    		System.out.println("Player wins");
    		player.bankroll += bet;
    	} else if (sum1 < sum2) {
    		System.out.println("Dealer wins");
    		player.bankroll -= bet;
    	} else {
    		System.out.println("Push");
    	}
    };
    // compare the count and give back reward to player if win.

}
