
public class TestBed {
	public static void main(String[] args) {
		
		//tests the add() function in ShoppingBag
		GroceryItem addTestItem = new GroceryItem("chocolate", 3.75, true);
		ShoppingBag TestBag = new ShoppingBag();
		TestBag.add(addTestItem);
		TestBag.print();
		
		//tests the remove() function in ShoppingBag
		GroceryItem removeTestItem1 = new GroceryItem("chocolate", 3.75, true);
		System.out.println(TestBag.remove(removeTestItem1));
		TestBag.add(addTestItem);
		GroceryItem removeTestItem2 = new GroceryItem("strawberry", 3.50, true);
		System.out.println(TestBag.remove(removeTestItem2));
		
		
	}
}
