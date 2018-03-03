package shop;

public class Sundae extends IceCream{
	
	private String toppingName;
	private int toppingPrice;
	
	public Sundae(String name,int price,String toppingName,int toppingPrice) {
		super(name, price);
		this.toppingName = toppingName;
		this.toppingPrice = toppingPrice;
	}
	
	
	public String getToppingName() {
		return toppingName;
	}
	
	


	public void setToppingName(String toppingName) {
		this.toppingName = toppingName;
	}


	public int getToppingPrice() {
		return toppingPrice;
	}


	public void setToppingPrice(int toppingPrice) {
		this.toppingPrice = toppingPrice;
	}


	@Override
	public int getCost() {
		return this.price + this.toppingPrice;
	}
	
	@Override
	public String toString() {
		return this.toppingName + " Sundae with\n" + this.name;
	}
	
	public static void main(String[] args) {
		System.out.println(new Sundae("Vanilla Ice Cream", 105, "Caramel", 50).toString());
	}

}
