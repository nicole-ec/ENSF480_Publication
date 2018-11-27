package buyers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

import shared.*;

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
	public Document searchCatalog(String title, Inventory inventory) throws IOException{
		// TODO Auto-generated method stub
		
		showInventory(inventory);
		System.out.println("Printed inventory");
		
		for (int i=0; i<inventory.getList().size(); i++) {
			if (title.equalsIgnoreCase(inventory.getList().get(i).getTitle())) {
				return inventory.getList().get(i);
			}
		}
		return null;
	}
	
	private void showInventory(Inventory invent) {
		for(int i=0; i<invent.getList().size(); i++) {
			System.out.println(invent.getList().get(i).getTitle());
			
		}
		System.out.println("size of inventory is: "+invent.getList().size());
	}

}
