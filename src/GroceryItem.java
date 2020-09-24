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
	@param	name	the name of the new Grocery Item
	@param	price	the price of the new Grocery Item
	@param	taxable	true if the new Grocery Item is taxable, false otherwise
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
	@param	obj	the object to be checked against this Grocery Item for equality
	@return	true if this Grocery Item and the given object are equal, false otherwise
	*/
	public boolean equals(Object obj) {
		if (!(obj instanceof GroceryItem)) return false;
		GroceryItem item = (GroceryItem) obj;
		if (name.equals(item.name) && price == item.price && taxable == item.taxable) return true;
		else return false;
	}
	
	/**
	Creates a string representation of this grocery item for easy display.
	@return	a string showing the name, price, and taxable status of grocery item
	*/
	public String toString() {
		return name + ": $" + String.format("%.2f", price) + " : " + (taxable ? "is taxable" : "tax free");
	}
	
	/**
	Retrieves the name of the grocery item.
	@return	name of the grocery item
	*/
	public String getName() {
		return name;
	}
	
	/**
	Retrieves the price of this item.
	@return	price of the grocery item
	*/
	public double getPrice() {
		return price;
	}
	
	/**
	Retrieves the taxable status of this item.
	@return	true if the grocery item is taxable, false otherwise
	*/
	public boolean isTaxable() {
		return taxable;
	}
}
