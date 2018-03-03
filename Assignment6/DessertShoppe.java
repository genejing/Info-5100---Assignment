package shop;

public class DessertShoppe {
	
	private String name;
	private double taxRate;
	private int maxSize;
	private int width;
	
	public DessertShoppe(String name, double taxRate, int maxSize,int width) {
		this.name = name;
		this.taxRate = taxRate;
		this.maxSize = maxSize;
		this.width = width;
	}
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(double taxRate) {
		this.taxRate = taxRate;
	}

	public int getMaxSize() {
		return maxSize;
	}

	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	
	public String cents2dollarsAndCentsmethod(int cents) {
		return String.valueOf(cents/100f);
	}

}
