package shop;

import java.util.Vector;


public class Checkout {
	
	Vector<DessertItem> itemList;
	
	DessertShoppe dShoppe = new DessertShoppe("M & M Dessert Shoppe",0.065,25,30);
	
	
	
	public Checkout() {
		itemList = new Vector<>();
		
	}
	
	public int numberOfItems() {
		return itemList.size();
	}
	
	public void enterItem(DessertItem item) {
		
		itemList.add(item);
	}
	
	public void clear() {
		itemList.clear();
	}
	
	public int totalCost() {
		int result = 0;
		for (DessertItem dItem:itemList) {
			result += dItem.getCost();
		}
		return result;
	}
	
	public int totalTax() {
		return (int)Math.round(totalCost() * dShoppe.getTaxRate());
	}
	
	
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder("");
		for (int i=0;i<(dShoppe.getWidth()-dShoppe.getName().length())/2 + 4;i++) {
			res.append(" ");
		}
		
		res.append(dShoppe.getName()).append("\n");
		
		for (int i = 0;i < dShoppe.getWidth() + 4;i++) {
			res.append("-");
		}
		res.append("\n");
		for (DessertItem dItem:itemList) {
			res.append(dItem.toString());
			if (dItem.getName().length() < dShoppe.getMaxSize()) {
				for(int i = 0;i < dShoppe.getWidth() - dItem.getName().length();i++) {
					res.append(" ");
				}
			}
			
			res.append(dShoppe.cents2dollarsAndCentsmethod(dItem.getCost()));
			res.append("\n");
		}
		res.append("\n");
		res.append("Tax");
		for(int i = 0;i < dShoppe.getWidth() - "tax".length();i++) {
			res.append(" ");
		}
		res.append(String.valueOf(dShoppe.cents2dollarsAndCentsmethod(totalTax())));
		
		res.append("\nTotal Cost");
		for(int i = 0;i < dShoppe.getWidth() - "Total Cost".length();i++) {
			res.append(" ");
		}
		res.append(String.valueOf(dShoppe.cents2dollarsAndCentsmethod(totalCost()+totalTax())));
		return res.toString();
	}

}
