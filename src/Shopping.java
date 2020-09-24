import java.util.Scanner;

public class Shopping {
	public void run() {
		ShoppingBag bag = new ShoppingBag();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Let's start shopping!");
		while (executeCommand(bag, scanner.nextLine()));
		System.out.println("Thanks for shopping with us!");
		
		scanner.close();
	}
	
	private boolean executeCommand(ShoppingBag bag, String command) {
		String[] args = command.split(" |\t");
		if (args.length < 1) {
			invalidCommand();
			return true;
		}
		switch (args[0]) {
		case "A":
			add(bag, args);
			break;
		case "R":
			remove(bag, args);
			break;
		case "P":
			print(bag, args);
			break;
		case "C":
			checkout(bag, args);
			break;
		case "Q":
			if (bag.getSize() != 0) checkout(bag, args);
			return false;
		default:
			invalidCommand();
			break;
		}
		return true;
	}
	
	private void invalidCommand() {
		System.out.println("Invalid command!");
	}
	private void add(ShoppingBag bag, String[] args) {
		if (args.length != 4) {
			invalidCommand();
			return;
		}
		bag.add(new GroceryItem(args[1], Double.parseDouble(args[2]), Boolean.parseBoolean(args[3])));
		System.out.println(args[1] + " added to the bag.");
	}
	private void remove(ShoppingBag bag, String[] args) {
		if (args.length != 4) {
			invalidCommand();
			return;
		}
		if (bag.remove(new GroceryItem(args[1], Double.parseDouble(args[2]), Boolean.parseBoolean(args[3])))) {
			System.out.printf("%s %.2f removed.", args[1], Double.parseDouble(args[2]));
		}
		else {
			System.out.println("Unable to remove, this item is not in the bag.");
		}
		
	}
	private void print(ShoppingBag bag, String[] args) {
		if (args.length > 1) {
			invalidCommand();
			return;
		}
		if(bag.getSize()==0) {
			System.out.println("The bag is empty!");
			return;
		}
		System.out.println("**You have "+bag.getSize()+" item(s) in the bag:");
		bag.print();
		System.out.println("**End of list");
	}
	private void checkout(ShoppingBag bag, String[] args) {
		if (args.length > 1) {
			invalidCommand();
			return;
		}
		if (bag.getSize() == 0) {
			System.out.println("Unable to check out, the bag is empty!");
			return;
		}
		System.out.println("**Checking out " + bag.getSize() + " items.");
		bag.print();
		double salesPrice = bag.salesPrice(), salesTax = bag.salesTax();
		System.out.println("*Sales total: $" + String.format("%.2f", salesPrice));
		System.out.println("*Sales tax: $" + String.format("%.2f", salesTax));
		System.out.println("*Total amount paid: $" + String.format("%.2f", salesPrice + salesTax));
	}
}
