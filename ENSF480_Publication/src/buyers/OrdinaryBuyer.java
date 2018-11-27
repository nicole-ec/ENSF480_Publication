package buyers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

import shared.Document;

public class OrdinaryBuyer extends Buyer{

	private boolean isSubscribed;
	private String email;
	private String creditCard;
	
	public OrdinaryBuyer() {
		super();
		isSubscribed = false;
	}
	
	public boolean subscribe(String username, String password) throws IOException {
		isSubscribed = true;
				
		BufferedReader reader = new BufferedReader(new FileReader("login.txt"));
		String line = reader.readLine();
		while (line != null) {
			String[] parts = line.split(";");
			if (username.equals(parts[0])) {
				return false;
			}
			line = reader.readLine();
		}
		reader.close();
		
		Writer output = new BufferedWriter(new FileWriter("login.txt", true));
		output.append("\n"+username+";"+password+";"+"R");
		output.close();
		return true;
	}
	
	@Override
	public Document searchCatalog(String title) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader reader = new BufferedReader(new FileReader("documents.txt"));
		String line = reader.readLine();
		while (line != null) {
			
			if (line.isEmpty()) {
				line = reader.readLine();
				continue;
			}
			
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
