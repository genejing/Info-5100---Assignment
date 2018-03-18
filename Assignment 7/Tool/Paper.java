package Assignment7;

public class Paper extends Tool{
	
	public Paper() {
		super();
	}
	public Paper(int strength){
		this.strength = strength;
		this.type = 'p';
	}
	
	public boolean fight(Tool tool) {
		if (tool.type == 'r') {
			return (this.strength * 2 > tool.strength);
		} else if (tool.type == 's') {
			return (this.strength / 2f > tool.strength);
		} else {
			return false;
		}
	}
}
