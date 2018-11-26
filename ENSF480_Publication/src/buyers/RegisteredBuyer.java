package buyers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

import shared.Document;

public class RegisteredBuyer extends Buyer{
	
	private String email;
	private String creditCard;
	private String username;
	private String password;
	private ArrayList<Promotion> promo;
	
	public RegisteredBuyer(String username, String password, String email, String creditCard, ArrayList<Promotion> promo) {
		super();
		isSubscribed = true;
		this.email = email;
		this.creditCard = creditCard;
		this.username = username;
		this.password = password;
		this.promo = promo;
	}
	
	public void unsubscribe() throws IOException {
		isSubscribed = false; 
				
		File fileName = new File("login.txt");
		File tempFile = new File("login1.txt");

		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

		String lineToRemove = username;
		String currentLine;

		while((currentLine = reader.readLine()) != null) {
		    // trim newline when comparing with lineToRemove
		    String trimmedLine = currentLine.trim();
		    if(trimmedLine.contains(lineToRemove)) continue;
		    writer.write(currentLine + System.getProperty("line.separator"));
		}
		writer.close(); 
		reader.close();
		fileName.delete();
		tempFile.renameTo(fileName);
	}
	
	public void addPromo(Promotion p) {
		promo.add(p);
	}

	@Override
	public Document searchCatalog(String title) throws IOException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order makeOrder(Document d) {
		// TODO Auto-generated method stub
		return null;
	}

}
