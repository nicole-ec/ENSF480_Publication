package shared;

public class Document {
	private long isbn;
	private String title;
	private String authorName;
	private double price;
	
	public Document (long isbn, String title, String authorName, double price) {
		this.isbn = isbn;
		this.title = title;
		this.authorName = authorName;
		this.price = price;
	}

	public double getPrice() {
		return price;
	}
	
	public long getIsbn() {
		return isbn;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return authorName;
	}
	

}
