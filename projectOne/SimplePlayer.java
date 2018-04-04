package blackJack;

import blackJack.Hand.HandValue;

public class SimplePlayer extends Player {
	
    SimplePlayer(int bankroll, int minimum) {
		super(bankroll, minimum);
		// TODO Auto-generated constructor stub
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
	public int bet() {
		
		return minimum;
	}

	@Override
	public void expose(Card c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void shuffled() {
		// TODO Auto-generated method stub
		
	}


	
  
}
