package buyers;

import java.util.ArrayList;

public class Order {
	
	private ArrayList<Document> docs;
	private double totalPrice;
	private String email;
	private int creditCard;
	
	public Order() {
		
	}
	
	public double calculateTotal() {
		
		for(Document d : docs) {
			totalPrice += d.price;
		}
		
		return totalPrice;
	}
	
}
