package buyers;
import java.util.ArrayList;

import shared.*;

public abstract class Buyer {

	protected boolean isSubscribed;
	protected ArrayList<Order> orders;
	
	public Buyer() {
		orders = new ArrayList<Order>();
	}
	
	public abstract Document searchCatalog();
	
	//maybe this function should be defined for all of them,
	//and just let each buyer have a different way to search
	//the catalog.
	public abstract Order makeOrder();
	
}
