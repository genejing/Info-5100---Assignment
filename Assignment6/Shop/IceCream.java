package shop;


public class IceCream extends DessertItem{
	
	protected int price;
	
	public IceCream(String name,int price) {
		super(name);
		this.price = price;
	}
	
	@Override
	public int getCost() {
		return this.price;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
	public static void main(String[] args) {
		System.out.println(new IceCream("Vanilla Ice Cream", 105).toString());
	}
	
}
