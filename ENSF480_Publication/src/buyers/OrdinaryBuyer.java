package buyers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
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
	public Document searchCatalog(String title) {
		// TODO Auto-generated method stub
		for(int i=0; i<inventory.getList().size(); i++) {
			if(inventory.getItem(i).getTitle().equalsIgnoreCase(title)) {
				return inventory.getItem(i);
			}
		}
		return null;
	}

	@Override
	public Order makeOrder(Document d) {
		// TODO Auto-generated method stub
		double totalPrice = order.calculateTotal();
		
		System.out.println("===============================RECEIPT===============================");
		
		
		
		return null;
	}

}
