public class ShoppingBag {
	private GroceryItem[] bag;
	private int size;
	
	private int find(GroceryItem item) {
		for (int i = 0; i < size; i++) {
			if (bag[i].equals(item)) return i;
		}
		return -1;
	}
}
