package blackJack;


public class blackjack {

    public static void main(String[] args) {
	    game(args);
    	
    }
    public static void game(String[] args) {
    	// write your code here first you need to use system in to ask four parameter from
        // console. Then run the game and print the relevant game step.
    	
    	int bankroll = Integer.parseInt(args[0]);
    	int maxTricks = Integer.parseInt(args[1]);
    	int minWager = Integer.parseInt(args[2]);
    	String playerType = args[3];
    	
    	System.out.println("Shuffling the deck");
    	    	
    	Trick trick = new Trick(playerType, bankroll, minWager);
    	Player player = trick.player;
    	Dealer dealer = trick.dealer;
    	Deck deck = trick.deck;
    	int cut = 7;
    	deck.shuffle(cut);
    	
    	int thisTrick;
    	
    	for (thisTrick = 0; thisTrick < maxTricks; thisTrick++) {
    		if (player.bankroll < minWager) break;
    		if (deck.cardsLeft() <= 20) {
    			deck.shuffle(cut);
    		}
    		trick.dealer.hand = new Hand();
        	trick.player.hand = new Hand();
        	int bet = player.bet();
    		System.out.println("Trick " + (thisTrick+1) + " bankroll " + player.bankroll);
        	System.out.println("Player bets " + bet);
        
        	
    		trick.DealFour();
    		int pSum = player.hand.sum();
    		for (Card c:player.hand.cards) {
    			if (c.getSpot().getValue() == 1) {
    				if (pSum + 10 < 21) {
    					player.hand.getHandValue().soft = true;
    					break;
    				} 
    			}
    		}
    		
    		boolean bust = false;
    		
    		if (player.hand.sum() == 21) {
    			
    			System.out.println("Player dealt natural 21");
    			player.bankroll += 3 * bet / 2;
    			System.out.println("Player wins");
    			System.out.println();
    			continue;
    		} 
    		
			while(player.draw(dealer.firstCard)) {
				trick.playerTurn();
				if (player.hand.sum() > 21) {
					System.out.println("Player's total is " + player.hand.sum());
					System.out.println("Player busts");
					player.bankroll -= bet;
					bust = true;
					break;
				} 
			}
			if (bust) {
				System.out.println();
				continue;
			} 
			System.out.println("Player's total is " + player.hand.sum());
			System.out.println("Dealer's hole card is " + dealer.holeCard.toString());
			while(dealer.draw()) {
				trick.dealerTurn();
				if (dealer.hand.sum() > 21) {
					System.out.println("Dealer's total is " + dealer.hand.sum());
					System.out.println("Dealer busts");
					player.bankroll += bet;
					bust = true;
					break;
				}
			}
			if (bust) {
				System.out.println();
				continue;
			}
			System.out.println("Dealer's total is " + dealer.hand.sum());
			trick.closeTurn(bet);
			System.out.println();
		
    	}
    	System.out.println("Player has " + player.bankroll + " after " + thisTrick + " tricks");
    	
    	
    }
}
