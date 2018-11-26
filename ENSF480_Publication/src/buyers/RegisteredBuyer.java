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
	private String username;
	private String password;
	private ArrayList<Promotion> promo;
	private long creditCard;
	
	public RegisteredBuyer(String username, String password, String email, long creditCard, ArrayList<Promotion> promo) {
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
		    String trimmedLine = currentLine.trim();
		    if(trimmedLine.contains(lineToRemove)) continue;
		    writer.write(currentLine + System.getProperty("line.separator"));
		}
		writer.close(); 
		reader.close();
		fileName.delete();
		boolean success = tempFile.renameTo(fileName);
	}
	
	public void addPromo(Promotion p) {
		promo.add(p);
	}

	@Override
	public Document searchCatalog(String title) throws IOException{
		// TODO Auto-generated method stub
		
		if(promo != null) {
			for(int i=0; i<promo.size();i++) {
				if (title.equalsIgnoreCase(promo.get(i).getDoc().getTitle())) {
					Document doc = new Document(promo.get(i).getDoc().getIsbn(), promo.get(i).getDoc().getTitle(), promo.get(i).getDoc().getAuthor(), promo.get(i).getPrice());
					return doc;
				}
			}
		}
		
		BufferedReader reader = new BufferedReader(new FileReader("documents.txt"));
		String line = reader.readLine();
		while (line != null) {
			String[] parts = line.split(";");
			if (title.equalsIgnoreCase(parts[1])) {
				Document doc = new Document(Integer.parseInt(parts[0]), parts[1], parts[2], Double.parseDouble(parts[3]));
				return doc;
			}
			line = reader.readLine();
		}
		reader.close();
		
		return null;
	}
}
