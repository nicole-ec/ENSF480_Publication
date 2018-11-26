package buyers;
import java.util.ArrayList;

import shared.*;

public abstract class Buyer {

	protected boolean isSubscribed;
	protected Order order;
	protected Inventory inventory;
	
	public Buyer() {
		order = new Order();
		inventory = new Inventory();
	}
	
	public Order getOrder() {
		return order;
	}
	
	public abstract Document searchCatalog(String title);
	
	//maybe this function should be defined for all of them,
	//and just let each buyer have a different way to search
	//the catalog.
	public abstract Order makeOrder(Document d);
	
}
