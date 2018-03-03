package shop;

public class Cookie extends DessertItem{
	
	private int number;
	private double pricePerDozen;
	
	public Cookie(String name,int number, double pricePerDozen) {
		super(name);
		this.number = number;
		this.pricePerDozen = pricePerDozen;
	}
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public double getPrice() {
		return pricePerDozen;
	}
	public void setPrice(double pricePerDozen) {
		this.pricePerDozen = pricePerDozen;
	}
	
	@Override
	public int getCost() {
		return (int) Math.round(number/12f * pricePerDozen);
	}
	
	@Override
	public String toString() {
		return  this.number + " @ " +this.pricePerDozen + " /dz." + "\n" + this.name;
	}
	
	public static void main(String[] args) {
		System.out.println(new Cookie("Chocolate Chip Cookies", 4, 399).toString());
	}
}
