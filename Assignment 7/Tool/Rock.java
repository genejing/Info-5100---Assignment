package Assignment7;

public class Rock extends Tool{
	
	public Rock() {
		super();
	}
	public Rock(int strength){
		this.strength = strength;
		this.type = 'r';
	}
	
	public boolean fight(Tool tool) {
		if (tool.type == 'p') {
			return (this.strength / 2f > tool.strength);
		} else if (tool.type == 's') {
			return (this.strength * 2 > tool.strength);
		} else {
			return false;
		}
	}
	
}
