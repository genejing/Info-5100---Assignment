package blackJack;

import blackJack.Hand.HandValue;

public class CountingPlayer extends Player {

    int memoryCard;

    CountingPlayer(int bankroll, int minimum){
        super(bankroll, minimum);
        memoryCard = 0;
    }

    @Override
    public int bet() {
    	
    	if (memoryCard >= 2 && bankroll >= 2 * minimum) {
    		return 2 * minimum;
    	} else {
    		return minimum;
    	}
    }

    @Override
    public boolean draw(Card dealer) {
    	Hand hand = this.hand;
		HandValue curValue = hand.getHandValue();
    	boolean soft = curValue.soft;
    	int count = hand.sum();
    	int spotValue = dealer.getSpot().getValue();
    	if (!soft) {
    		if (count <= 11) return true;
    		if (count == 12) {
    			if (spotValue >= 4 && spotValue <= 6) {
    				return false;
    			} else {
    				return true;
    			}
    		}
    		if (count >= 13 && count  <= 16) {
    			if (spotValue >= 2 && spotValue <= 6) {
    				return false;
    			} else {
    				return true;
    			}
    		}
    		if (count >= 17) return false;
    	} else {
    		if (count <= 17) return true;
    		if (count == 18) {
    			if (spotValue == 2 || spotValue == 7 || spotValue == 8) return false;
    			return true;
    		}
    		if (count == 19) return false;
    	}
        return false;
   	}

    @Override
    public void expose(Card c) {
    	Spot spotValue = c.getSpot();
    	if (spotValue.equals(Spot.TEN) || spotValue.equals(Spot.JACK) 
    		|| spotValue.equals(Spot.QUEEN) || spotValue.equals(Spot.KING) || spotValue.equals(Spot.ACE)) {
    		memoryCard--;
    	}
    	if (spotValue.equals(Spot.TWO) || spotValue.equals(Spot.THREE) || spotValue.equals(Spot.FOUR)
    			|| spotValue.equals(Spot.FIVE) || spotValue.equals(Spot.SIX)) {
    		memoryCard++;
    	}
    }

    @Override
    public void shuffled() {
    	memoryCard = 0;
    }
}

