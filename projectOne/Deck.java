package blackJack;

import java.util.LinkedList;
import java.util.Queue;

class DeckEmptyExecption extends Exception { // An exception type
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String toString() {
		return "Deck is Empty";
	}
};


public class Deck extends GroupOfCards {

    final int DeckSize = 52;
    // A standard Deck of 52 playing card---no jokers
    
   

    Deck(){
    	for (Suit suit:Suit.values()) {
    		
    		for (Spot spot:Spot.values()) {
        		Card card = new Card(spot, suit);
        		this.cards.add(card);
        	}
    	}
    };

    // EFFECTS: constructs a "newly opened" Deck of card.  first the
    // spades from 2-A, then the hearts, then the clubs, then the
    // diamonds.  The first Card dealt should be the 2 of Spades.

    void reset(){
    	new Deck();
    };

    // EFFECTS: resets the Deck to the state of a "newly opened" Deck
    // of card:

    void shuffleOnce(int n){
    	if (n <= 0 || n >=52) {
    		return;
    	}
    	if (cards.size() != DeckSize) {
    		while(!dealCards.isEmpty()) {
    			cards.add(dealCards.poll());
    		}
    	}
    	
    	Queue<Card> left = new LinkedList<Card>();
    	Queue<Card> right = new LinkedList<Card>();
    	for (int i = 0; i < n;i++) {
    		left.add(cards.poll());
    	}
    	for (int i = 0;i < cards.size()-n;i++) {
    		right.add(cards.poll());
    	}
    	while (left.size() != 0 && right.size() !=0 ) {
    		cards.add(left.poll());
    		cards.add(right.poll());
    	}
    	
    	while (left.size() != 0) {
    		cards.add(left.poll());
    	}
    	
    	while (right.size() != 0) {
    		cards.add(right.poll());
    	}
    	
    	
    };

    // REQUIRES: n is between 0 and 52, inclusive.

    // EFFECTS: cut the Deck into two segments: the first n card,
    // called the "left", and the rest called the "right".  Note that
    // either right or left might be empty.  Then, rearrange the Deck
    // to be the first Card of the right, then the first Card of the
    // left, the 2nd of right, the 2nd of left, and so on.  Once one
    // side is exhausted, fill in the remainder of the Deck with the
    // card remaining in the other side.  Finally, make the first
    // Card in this shuffled Deck the next Card to deal.  For example,
    // shuffle(26) on a newly-reset() Deck results in: 2-clubs,
    // 2-spades, 3-clubs, 3-spades ... A-diamonds, A-hearts.

    // Note: if shuffle is called on a Deck that has already had some
    // card dealt, those card should first be restored to the Deck
    // in the order in which they were dealt, preserving the most
    // recent post-shuffled/post-reset state.

    void shuffle(int times){
    	
    	for (int i = 0;i < times; i++) {
    		int low = 13;
    		int high = 39;
    		int n = (int) (Math.random()*(high - low) + low);
    		System.out.println("cut at " + n);
    		shuffleOnce(n);
    	}
    };
    // REQUIRES: times is the time of using shuffleOnce method to shuffle
    // cards, normally time should be at least 5.

    //EFFECTS: In each time, use Math.random to pick an cut number between
    // 13 - 39, and then call shuffleOnce method with the number;

    Card deal() throws DeckEmptyExecption{
    	if (cards.isEmpty()) {
    		reset();
    		throw new DeckEmptyExecption();
    		
    	} else {
    		return cards.peek();
    	}
    	
       
    };

    // EFFECTS: returns the next Card to be dealt.  If no card
    // remain, throws an instance of DeckEmptyExecption and then
    // sreset the deck

    int cardsLeft(){
        return cards.size();
    };
    // EFFECTS: returns the number of card in the Deck that have not
    // been dealt since the last reset/shuffle.

}
