public class ShoppingBag {
	private static final int STARTING_CAPACITY = 5;
	private static final int CAPACITY_GROWTH = 5;
	private static final double SALES_TAX = 0.06625;
	
	private GroceryItem[] bag;
	private int size;
	
	public ShoppingBag() {
		bag = new GroceryItem[STARTING_CAPACITY];
		size = 0;
	}
	
	private int find(GroceryItem item) {
		for (int i = 0; i < size; i++) {
			if (bag[i].equals(item)) return i;
		}
		return -1;
	}
	
	private void grow() {
		GroceryItem[] newBag = new GroceryItem[bag.length + CAPACITY_GROWTH];
		for (int i = 0; i < size; i++) {
			newBag[i] = bag[i];
		}
		bag = newBag;
	}
	
	public void add(GroceryItem item) {
		if (size == bag.length) grow();
		bag[size++] = item;
	}
	
	public boolean remove(GroceryItem item) {
		int index = find(item);
		if (index == -1) return false;
		bag[index] = bag[size];
		bag[size--] = null;
		return true;
	}
	
	public double salesPrice() {
		double totalPrice = 0;
		for (int i = 0; i < size; i++) {
			totalPrice += bag[i].getPrice();
		}
		return totalPrice;
	}
	
	public double salesTax() {
		double taxablePrice = 0;
		for (int i = 0; i < size; i++) {
			if (bag[i].isTaxable()) taxablePrice += bag[i].getPrice(); 
		}
		return taxablePrice * SALES_TAX;
	}
	
	public void print() { }
}
