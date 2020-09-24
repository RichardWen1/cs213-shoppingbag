
public class TestBed {
	public static void main(String[] args) {
		GroceryItem addtestitem = new GroceryItem("chocolate", 3.75, true);
		ShoppingBag addtestbag = new ShoppingBag();
		addtestbag.add(addtestitem);
		addtestbag.print();
	}
}
