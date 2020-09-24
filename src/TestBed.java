/**
Tests the add(), remove(), grow(), and salesTax() methods in the ShoppingBag class.
Test cases are documented in the TestSpecification.doc document
@author Richard Wen, Elise Merritt
*/
public class TestBed {
	public static void main(String[] args) {
		
		//tests the add() method in ShoppingBag
		GroceryItem addTestItem = new GroceryItem("chocolate", 3.75, true);
		ShoppingBag testBag = new ShoppingBag();
		testBag.add(addTestItem);
		testBag.print();
		
		//tests the remove() method in ShoppingBag
		GroceryItem removeTestItem1 = new GroceryItem("chocolate", 3.75, true);
		System.out.println(testBag.remove(removeTestItem1));
		testBag.add(removeTestItem1);
		GroceryItem removeTestItem2 = new GroceryItem("strawberry", 3.50, true);
		System.out.println(testBag.remove(removeTestItem2));
		
		//tests the salesTax() method in ShoppingBag
		GroceryItem salesTaxTestItem1 = new GroceryItem("chocolate", 3.75, true);
		GroceryItem salesTaxTestItem2 = new GroceryItem("strawberry", 3.50, true);
		GroceryItem salesTaxTestItem3 = new GroceryItem("vanilla", 3.75, false);
		testBag.add(salesTaxTestItem1);
		testBag.add(salesTaxTestItem2);
		testBag.add(salesTaxTestItem3);
		System.out.println(testBag.salesTax());
		
	}
}
