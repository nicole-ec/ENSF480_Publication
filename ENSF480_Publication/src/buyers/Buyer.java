package buyers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import shared.*;

public abstract class Buyer {

	protected boolean isSubscribed;
	protected Order order;
	protected Inventory inventory;

	public Buyer() {
		order = new Order();
		inventory = new Inventory();
	}

	public Order getOrder() {
		return order;
	}

	public abstract Document searchCatalog(String title) throws IOException;

	// maybe this function should be defined for all of them,
	// and just let each buyer have a different way to search
	// the catalog.
	public void makeOrder() {
		double totalPrice = 0, shipping = 0;

		System.out.println("\n\n===============================RECEIPT===============================\n\n\n" 
							+ "Documents:\t\t\tPrice:");

		for (int i = 0; i < order.getDoc().size(); i++) {

			System.out.println(order.getDoc().get(i).getTitle() + "\t\t\t" + order.getDoc().get(i).getPrice());

			totalPrice += order.getDoc().get(i).getPrice();

		}
		shipping = totalPrice * 0.10;
		totalPrice += shipping;
		System.out.println("\n\nShipping\t\t\t\t"+shipping+"\n\n\n==================================================================\n"
							+"Total price:\t\t\t" 
							+ totalPrice + "\nPaid with credit card.");
	}

	public void showList() {
		
		if(order.getDoc() == null || order.getDoc().isEmpty()) {
			System.out.println("You have no orders!");
			return;
		}
		
		System.out.println("Document\t\t\t\tPrice\n" + "___________________________________________________\n\n");
		
		for (int i = 0; i < order.getDoc().size(); i++) {
			System.out.println(order.getDoc().get(i).getTitle() + "\t\t\t" + order.getDoc().get(i).getPrice());
			
		}
	}
	
	public void resetOrder() {
		order = new Order();
		System.out.println("cleared order successfully");
	}

}
