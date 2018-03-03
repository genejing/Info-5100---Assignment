package shop;

import java.math.BigDecimal;

public class Candy extends DessertItem{
	
	private double weight;
	private double pricePerPound;
	
	public Candy(String name,double weight, double pricePerPound) {
		super(name);
		this.weight = weight;
		this.pricePerPound =  pricePerPound;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getPrice() {
		return pricePerPound;
	}
	public void setPrice(double pricePerPound) {
		this.pricePerPound = pricePerPound;
	}
	
	@Override
	public int getCost() {
		BigDecimal bigDecimal = new BigDecimal(pricePerPound * weight);
		long f = Math.round(bigDecimal.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue());
		return (int)f;
	}
	
	@Override
	public String toString() {
		return  this.weight + " lbs. @ " + (this.pricePerPound/100f) + " /lb." + "\n" + this.name;
	}
	
	public static void main(String[] args) {
		System.out.println(new Candy("Peanut Butter Fudge", 2.25, 399).toString());
	}
	
	
	
}
