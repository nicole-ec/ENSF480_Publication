package buyers;

import java.util.ArrayList;

import shared.Document;

public class Order {
	
	private ArrayList<Document> docs;
	private double totalPrice;
	private String email;
	private int creditCard;
	
	public Order() {
		docs = new ArrayList<Document>();
	}
	
	public void addDoc(Document d) {
		docs.add(d);
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setCreditCard(int creditCard) {
		this.creditCard = creditCard;
	}
	
	public ArrayList<Document> getDoc(){
		return docs;
	}
	
	public double calculateTotal() {
		
		for(Document d : docs) {
			totalPrice += d.getPrice();
		}
		
		return totalPrice;
	}
	
}
