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
}
