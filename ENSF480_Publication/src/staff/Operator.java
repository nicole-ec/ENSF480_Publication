package staff;

import java.util.ArrayList;

import buyers.Order;
import buyers.Promotion;
import shared.Document;
import shared.Inventory;

public class Operator extends Staff{
		
	Inventory inventory;

	public Operator(String name, String username, String password) {
		super(name, username, password);
	}
	
	public Inventory addDoc(Document doc) {
		inventory.add(doc);
		return null;
		
	}
	
	public Inventory removeDoc(int isbn) {
		
		for(int i = 0; i<inventory.getList().size(); i++)
		{
			if(inventory.getItem(i).getIsbn() == isbn)
			{
				inventory.getList().remove(i);
			}
		}
		return null;
		
	}
	
	public Inventory updateDoc(ArrayList<Document> arr) {
	
		for(int i = 0; i<inventory.getList().size();i++)
		{
			inventory.getList().set(i,arr.get(i));
		}
		return null;
	
	}
}
