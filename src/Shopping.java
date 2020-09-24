/**
Allows user to shop for grocery items by adding and removing 
new grocery items to and from a shopping bag, then checking them out.
Handles user input as one-letter commands and then outputs results.
@author Richard Wen, Elise Merritt
*/

import java.util.Scanner;

public class Shopping {
	/**
	Method that runs project by creating a shopping bag, then allowing users 
	to manipulate bag contents through one-letter inputs until the quit (Q)
	command is received. User inputs processed using Scanner class.
	*/
	public void run() {
		ShoppingBag bag = new ShoppingBag();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Let's start shopping!");
		while (executeCommand(bag, scanner.nextLine()));
		System.out.println("Thanks for shopping with us!");
		
		scanner.close();
	}
	
	/**
	Receives user inputs and then takes action appropriate to input.
	Users may add grocery items to a shopping bag (A), remove grocery items
	from a shopping bag (R), print the contents of a bag (P), checkout the contents
	of a bag (C), and quit shopping (Q, which also automatically checks out bag 
	contents) using the appropriate one-letter command. Any other commands are 
	considered invalid.
	@param a Shopping bag the user wants to manipulate by shopping
	@param a String input command from the user. If the command is valid (is A, R, P, 
	C, or Q) then an action will be taken.
	@return true if the user is not finished shopping, otherwise false
	*/
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
	
	/**
	Handles invalid inputs from the user by printing an error message.
	Input is considered invalid if it is not A, R, P, C, or Q.
	*/
	private void invalidCommand() {
		System.out.println("Invalid command!");
	}
	
	/**
	Creates a new Grocery item using user input and adds it to a shopping bag.
	Item will not be added and created if user input is not valid, or does not
	contain the name, price, and taxable status of the Grocery Item to be made.
	Items can only be added one item at a time.
	@param the Shopping Bag the user wants to add a Grocery Item to.
	@param a String containing the name, price, and taxable status of the desired
	Grocery Item, separated by whitespace. The Add command (A) should begin the string.
	*/
	private void add(ShoppingBag bag, String[] args) {
		if (args.length != 4) {
			invalidCommand();
			return;
		}
		bag.add(new GroceryItem(args[1], Double.parseDouble(args[2]), Boolean.parseBoolean(args[3])));
		System.out.println(args[1] + " added to the bag.");
	}
	
	/**
	Removes a Grocery Item from a shopping bag.
	Item must be present in the given shopping bag to be removed.
	Item will not be removed if user input is not valid, or does not
	contain the name, price, and taxable status of the Grocery Item to be removed.
	Items can only be removed one item at a time.
	@param the Shopping Bag the user wants to remove a Grocery Item from.
	@param a String containing the name, price, and taxable status of the Grocery Item 
	to be removed, separated by whitespace. The Remove command (R) should begin the string.
	*/
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
	
	/**
	Prints the contents of a shopping bag for the user.
	Will tell the user the bag is empty, or tell the user the number of items in
	the bag, followed by a list of the items in the bag.
	@param the Shopping Bag the user wants to see the contents of
	@param the String input command telling the program to show the contents of the
	bag. Should consist of only one letter (P).
	*/
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
	
	/**
	Checks out a shopping bag for the user.
	Checkout process consists of displaying the bag's contents, then calculating
	and displaying the total price and tax of all the items in the bag.
	Will not check out an empty bag and instead will print an error message.
	@param the Shopping bag the user wants to checkout
	@param the String input command telling the program to show the contents of the
	bag. Should consist of only one letter (C).
	*/
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
