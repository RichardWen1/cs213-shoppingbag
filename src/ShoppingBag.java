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
	The shopping bag is initially set to a built-in starting capacity
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
		bag[index] = bag[size - 1];
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
	
	/**
	Completely empties the Shopping Bag.
	For use specifically when checking out the bag.
	*/
	public void empty() {
		bag = new GroceryItem[STARTING_CAPACITY];
		size = 0;
	}
	
	/**
	Tests the add(), remove(), grow(), salesTax() functions of the ShoppingBag class
	Makes three ShoppingBag instances with several Grocery Items as test cases
	See TestSpecification.doc document for further details on test cases.
	*/
	public static void main(String[] args) {
		
		//tests the add() method in ShoppingBag
		GroceryItem addTestItem = new GroceryItem("chocolate", 3.75, true);
		ShoppingBag testBag1 = new ShoppingBag();
		testBag1.add(addTestItem);
		testBag1.print();
		
		//tests the remove() method in ShoppingBag
		GroceryItem removeTestItem1 = new GroceryItem("chocolate", 3.75, true);
		System.out.println(testBag1.remove(removeTestItem1));
		testBag1.add(removeTestItem1);
		GroceryItem removeTestItem2 = new GroceryItem("strawberry", 3.50, true);
		System.out.println(testBag1.remove(removeTestItem2));
		
		//tests the grow() method in ShoppingBag
		ShoppingBag testBag2 = new ShoppingBag();
		GroceryItem growTestItem1 = new GroceryItem("chocolate", 3.75, true);
		GroceryItem growTestItem2 = new GroceryItem("strawberry", 3.50, true);
		GroceryItem growTestItem3 = new GroceryItem("vanilla", 3.75, false);
		GroceryItem growTestItem4 = new GroceryItem("pistachio", 5.00, false);
		GroceryItem growTestItem5 = new GroceryItem("blueberry", 4.75, true);
		GroceryItem growTestItem6 = new GroceryItem("cookie dough", 2.54, true);
		testBag2.add(growTestItem1);
		testBag2.add(growTestItem2);
		testBag2.add(growTestItem3);
		testBag2.add(growTestItem4);
		testBag2.add(growTestItem5);
		testBag2.add(growTestItem6);
		testBag2.print();
		
		//tests the salesTax() method in ShoppingBag
		ShoppingBag testBag3 = new ShoppingBag();
		GroceryItem salesTaxTestItem1 = new GroceryItem("chocolate", 3.75, true);
		GroceryItem salesTaxTestItem2 = new GroceryItem("strawberry", 3.50, true);
		GroceryItem salesTaxTestItem3 = new GroceryItem("vanilla", 3.75, false);
		testBag3.add(salesTaxTestItem1);
		testBag3.add(salesTaxTestItem2);
		testBag3.add(salesTaxTestItem3);
		System.out.println(testBag3.salesTax());
		
	}
}
