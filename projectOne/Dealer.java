package blackJack;

public class Dealer {

    Hand hand;
    Card firstCard;
    Card holeCard;

    Dealer(){
    	this.hand = new Hand();
    };

    public boolean draw(){
    	int count = hand.sum();
    	if (count < 17) return true;
        return false;
    }
    // EFFECTS: For dealer The dealer must
    // hit until he either reaches a total greater than or equal to 17
    // (hard or soft), or busts.
}
