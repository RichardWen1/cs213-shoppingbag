/**
Tests the add(), remove(), grow(), and salesTax() methods in the ShoppingBag class.
Test cases are documented in the TestSpecification.doc document
@author Richard Wen, Elise Merritt
*/
public class TestBed {
	/**
	Uses test cases to test the add(), remove(), grow(), salesTax() in ShoppingBag class
	Makes three ShoppingBag instances with several Grocery Items as test cases
	See TestSpecification.doc document for further details.
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
