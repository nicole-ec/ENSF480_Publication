package shared;

import java.util.ArrayList;

public class Inventory {
	private ArrayList<Document> docs;
	
	public Inventory() {
		docs = new ArrayList<Document>();
	}
	
	public void update(ArrayList<Document> doc)
	{
		
	}

	public ArrayList<Document> getList() {
		
		return docs;
	}

	public Document getItem(int i) {
		// TODO Auto-generated method stub
		return docs.get(i);
	
	}

	public void add(Document doc) {
		// TODO Auto-generated method stub
		docs.add(doc);
	}

	
}
