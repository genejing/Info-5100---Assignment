package Assignment7;

public class Scissors extends Tool{

	public Scissors() {
		super();
	}
	
	public Scissors(int strength) {
		this.strength = strength;
		this.type = 's';
	}
	
	public boolean fight(Tool tool) {
		if (tool.type == 'p') {
			return (this.strength * 2 > tool.strength);
		} else if (tool.type == 'r') {
			return (this.strength / 2f > tool.strength);
		} else {
			return false;
		}
	}

}
