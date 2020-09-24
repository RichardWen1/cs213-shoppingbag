/**
This class represents a grocery item that can be purchased while shopping.
Each grocery item has a name and price, and may be taxed. The class also allows 
for checking if two grocery items are equal.
@author Richard Wen, Elise Merritt
*/
public class GroceryItem {
	private String name;
	private double price;
	private boolean taxable;
	
	/**
	Creates a new grocery item given the name, price and taxable status of the item.
	@param name of new grocery item
	@param price of new grocery item
	@param true if new grocery item is taxable, false otherwise
	*/
	public GroceryItem(String name, double price, boolean taxable) {
		this.name = name;
		this.price = price;
		this.taxable = taxable;
	}
	
	/**
	Checks if a given grocery item is equal to another grocery item.
	Two grocery items are considered equal if they are both grocery items and have 
	the same name, price, and taxable status.
	@param object to be checked against grocery item for equality
	@return true if grocery item and object given as parameter are equal, false otherwise
	*/
	public boolean equals(Object obj) {
		if (!(obj instanceof GroceryItem)) return false;
		GroceryItem item = (GroceryItem) obj;
		if (name.equals(item.name) && price == item.price && taxable == item.taxable) return true;
		else return false;
	}
	
	/**
	Creates string representation of grocery item for easy display
	@return a string showing the name, price, and taxable status of grocery item
	*/
	public String toString() {
		return name + ": $" + String.format("%.2f", price) + " : " + (taxable ? "is taxable" : "tax free");
	}
	
	/**
	Retrieves name of grocery item
	@return name of grocery item
	*/
	public String getName() {
		return name;
	}
	
	/**
	Retrieves price of grocery item
	@return price of grocery item
	*/
	public double getPrice() {
		return price;
	}
	
	/**
	Retrieves taxable status of grocery item
	@return true if grocery item taxable, false otherwise
	*/
	public boolean isTaxable() {
		return taxable;
	}
}
