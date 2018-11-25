package shared;

public class Document {
	private long isbn;
	private String title;
	private String authorName;
	private double price;
	
	public Document (int isbn, String title, String authorName) {
		this.isbn = isbn;
		this.title = title;
		this.authorName = authorName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
