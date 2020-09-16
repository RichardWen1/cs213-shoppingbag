public class GroceryItem {
	private String name;
	private double price;
	private boolean taxable;
	
	public boolean equals(Object obj) {
		if (!(obj instanceof GroceryItem)) return false;
		GroceryItem item = (GroceryItem) obj;
		if (name.equals(item.name) && price == item.price && taxable == item.taxable) return true;
		else return false;
	}
	
	public String toString() {
		return name + ": $" + String.format("%.2f", price) + " : " + (taxable ? "is taxable" : "tax free");
	}
	
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	public boolean isTaxable() {
		return taxable;
	}
}
