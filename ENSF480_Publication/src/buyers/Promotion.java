package buyers;

import shared.Document;

public class Promotion {
	
	private double salePrice;
	private Document doc;
	
	public Promotion(Document d, double price) {
		doc = d;
		salePrice = price;
	}
	
	public Document getDoc() {
		return doc;
	}
	
	public double getPrice() {
		return salePrice;
	}
}
