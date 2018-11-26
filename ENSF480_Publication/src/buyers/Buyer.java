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
		double totalPrice = 0;

		System.out.println("===============================RECEIPT===============================\n" 
							+ "Documents:\t\t\tPrice:");

		for (int i = 0; i < order.getDoc().size(); i++) {

			System.out.println(order.getDoc().get(i).getTitle() + "\t\t\t" + order.getDoc().get(i).getPrice());

			totalPrice += order.getDoc().get(i).getPrice();

		}

		System.out.println("==================================================================\nTotal price: " 
							+ totalPrice + "\nPaid with credit card.");
	}

	public void showList() {
		
		if(order.getDoc() == null) {
			System.out.println("You have no orders!");
			return;
		}
		
		System.out.println("Document\t\t\tPrice" + "___________________________________________________");
		
		for (int i = 0; i < order.getDoc().size(); i++) {
			System.out.println(order.getDoc().get(i).getTitle() + "\t\t\t" + order.getDoc().get(i).getPrice());
			
		}
	}

}
