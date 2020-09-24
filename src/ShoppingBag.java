/**
Shopping bag holds Grocery items desired by user while user is shopping.
Grocery items are held in an array representing the bag and can be added 
and removed. The number of items in a Shopping Bag and the total price and 
tax of all the items in a Shopping Bag can also be retrieved.
@author Richard Wen, Elise Merritt
*/
public class ShoppingBag {
	private static final int STARTING_CAPACITY = 5;
	private static final int CAPACITY_GROWTH = 5;
	private static final double SALES_TAX = 0.06625;
	
	private GroceryItem[] bag;
	private int size;
	
	/**
	Constructs a new Shopping Bag.
	The shopping bag is intially set to a built-in starting capacity
	and initially empty (size 0).
	*/
	public ShoppingBag() {
		bag = new GroceryItem[STARTING_CAPACITY];
		size = 0;
	}
	
	/**
	Returns the number of Grocery items currently in a Shopping Bag.
	@return size of the shopping bag
	*/
	public int getSize() {
		return size;
	}
	
	/**
	Finds a grocery item in a bag so it can be removed.
	@param Grocery item to look for in bag
	@return index of item in bag, or -1 if item is not found, 
	including when bag is empty.
	*/
	private int find(GroceryItem item) {
		for (int i = 0; i < size; i++) {
			if (bag[i].equals(item)) return i;
		}
		return -1;
	}
	
	/**
	Increases number of grocery items a Shopping Bag can hold by a set amount.
	A new, larger bag is created and all the items in the old bag are transferred to it,
	then the old bag is replaced by the new bag. The amount a bag can grow by is set by
	the program and cannot be changed.
	*/
	private void grow() {
		GroceryItem[] newBag = new GroceryItem[bag.length + CAPACITY_GROWTH];
		for (int i = 0; i < size; i++) {
			newBag[i] = bag[i];
		}
		bag = newBag;
	}
	
	/**
	Adds a Grocery Item to a shopping bag, increasing the capacity of the bag if needed.
	The total number of items in the bag is updated automatically.
	@param Grocery Item to be added to the Shopping Bag
	*/
	public void add(GroceryItem item) {
		if (size == bag.length) grow();
		bag[size++] = item;
	}
	/**
	Removes a Grocery Item from a shopping bag, if the item is in the bag.
	Item cannot be removed if it is not in the bag.
	The total number of items in the bag is updated automatically.
	@param Grocery Item to be removed from the Shopping Bag
	@return true if the item is successfully found and removed, false otherwise
	*/
	public boolean remove(GroceryItem item) {
		int index = find(item);
		if (index == -1) return false;
		bag[index] = bag[size];
		bag[size--] = null;
		return true;
	}
	
	/**
	Calculates the total price of all the Grocery Items in a Shopping Bag.
	Total price is the sum of the individual prices of each item in the bag.
	Total price of an empty bag is 0.
	@return total price of all Grocery Items in a Shopping Bag
	*/
	public double salesPrice() {
		double totalPrice = 0;
		for (int i = 0; i < size; i++) {
			totalPrice += bag[i].getPrice();
		}
		return totalPrice;
	}
	
	/**
	Calculates the total tax on all the Grocery Items in a Shopping Bag.
	Total tax is the sum of the prices of all the taxable Grocery Items in
	a bag, multiplied by a set, unchangeable percentage.
	@return total tax on all Grocery Items in a Shopping Bag
	*/
	public double salesTax() {
		double taxablePrice = 0;
		for (int i = 0; i < size; i++) {
			if (bag[i].isTaxable()) taxablePrice += bag[i].getPrice(); 
		}
		return taxablePrice * SALES_TAX;
	}
	 /**
	 Displays the Grocery items contained in a Shopping Bag.
	 The name, price, and taxable status is printed for each Grocery Item in
	 the bag.
	 */
	public void print() {
		for (int i = 0; i < size; i++) {
			System.out.println("\u2022" + bag[i].toString());
		}
	}
}
